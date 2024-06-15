package com.farmachinerental.platform.u202212721.inventories.application.internal.commandservices;

import com.farmachinerental.platform.u202212721.inventories.domain.model.aggregates.Tool;
import com.farmachinerental.platform.u202212721.inventories.domain.model.commands.CreateToolCommand;
import com.farmachinerental.platform.u202212721.inventories.domain.model.commands.RentalPriceWithNegativeOrZeroValueException;
import com.farmachinerental.platform.u202212721.inventories.domain.model.exceptions.InvalidCategoryTypeException;
import com.farmachinerental.platform.u202212721.inventories.domain.model.exceptions.ToolWithTheCurrentNameAlreadyExistException;
import com.farmachinerental.platform.u202212721.inventories.domain.services.ToolCommandService;
import com.farmachinerental.platform.u202212721.inventories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import com.farmachinerental.platform.u202212721.inventories.infrastructure.persistence.jpa.repositories.ToolRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ToolCommandServiceImpl
 * <p>
 *     This class implements the ToolCommandService interface.
 *     It is used to implement the business logic for the Tool entity.
 *     Resolve the contract defined in the ToolCommandService interface.
 *     Uses the @Service annotation to indicate that this class is a service.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@Service
public class ToolCommandServiceImpl implements ToolCommandService {
    private final ToolRepository toolRepository;
    private final CategoryRepository categoryRepository;

    public ToolCommandServiceImpl(ToolRepository toolRepository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.toolRepository = toolRepository;
    }

    /**
     * Handle the creation of a tool
     * <p>
     *     This method is used to handle the creation of a tool.
     * </p>
     * @param command CreateToolCommand
     * @return Optional<Tool>
     * @author U202212721 Mathias Jave Diaz
     */
    @Override
    public Optional<Tool> handle(CreateToolCommand command) {
        var category = categoryRepository.findById(command.categoryId());
        var tool  = new Tool(command,category.get());
        if(toolRepository.existsByName(tool.getName())){
            throw new ToolWithTheCurrentNameAlreadyExistException("Tool with: " + tool.getName() + " already exist");
        }
        if (command.rentalPrice() < 0){
            throw new RentalPriceWithNegativeOrZeroValueException("Rental price must be greater than 0");
        }
        if(!categoryRepository.existsById(command.categoryId())){
            throw new InvalidCategoryTypeException("Category with id: " + command.categoryId() + " does not exist");
        }
        return Optional.of(toolRepository.save(tool));
    }
}
