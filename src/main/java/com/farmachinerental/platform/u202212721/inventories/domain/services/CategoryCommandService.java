package com.farmachinerental.platform.u202212721.inventories.domain.services;


import com.farmachinerental.platform.u202212721.inventories.domain.model.commands.SeedCategoryTypesCommand;

/**
 * CategoryCommandService interface
 * <p>
 *     This interface is used to handle the commands related to the category
 *     and it has only one method to handle the SeedCategoryTypesCommand
 *     which is used to seed the category types.
 *     This interface is implemented by the CategoryCommandServiceImpl class.
 *     Uses dependency injection for follow the interface segregation principle.
 * </p>
 *
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public interface CategoryCommandService {

   void handle(SeedCategoryTypesCommand command);
}
