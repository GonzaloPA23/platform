package com.farmachinerental.platform.u202212721.inventories.application.internal.commandservices;

import com.farmachinerental.platform.u202212721.inventories.domain.model.commands.SeedCategoryTypesCommand;
import com.farmachinerental.platform.u202212721.inventories.domain.model.entities.Category;
import com.farmachinerental.platform.u202212721.inventories.domain.model.valueobjects.CategoryTypes;
import com.farmachinerental.platform.u202212721.inventories.domain.services.CategoryCommandService;
import com.farmachinerental.platform.u202212721.inventories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * CategoryCommandServiceImpl
 * <p>
 *     This class implements the CategoryCommandService interface.
 *     It is used for verified the category types when the application is ready to use.
 * </p>
 *
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {

    private final CategoryRepository categoryRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void handle(SeedCategoryTypesCommand command) {
        Arrays.stream(CategoryTypes.values()).forEach(categoryType -> {
            if (!categoryRepository.existsByType(categoryType)){
                categoryRepository.save(new Category(categoryType));
            }
        });
    }
}
