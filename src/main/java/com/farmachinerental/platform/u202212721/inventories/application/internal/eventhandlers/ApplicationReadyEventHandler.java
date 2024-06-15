package com.farmachinerental.platform.u202212721.inventories.application.internal.eventhandlers;

import com.farmachinerental.platform.u202212721.inventories.domain.model.commands.SeedCategoryTypesCommand;
import com.farmachinerental.platform.u202212721.inventories.domain.services.CategoryCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ApplicationReadyEventHandler
 * <p>
 *     This class is used to verify if the category types seeding is needed.
 * </p>
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@Service
public class ApplicationReadyEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    private final CategoryCommandService categoryCommandService;

    public ApplicationReadyEventHandler(CategoryCommandService categoryCommandService) {
        this.categoryCommandService = categoryCommandService;
    }


    /**
     * This method is used to verify if the category types seeding is needed.
     * <p>
     *     This method is called when the application is ready to use.
     * </p>
     * @param event ApplicationReadyEvent
     * @author U202212721 Mathias Jave Diaz
     */


    @EventListener
    public void on (ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getApplicationName();
        logger.info("Application {} is ready, starting to verify if category types seeding is needed.", applicationName);
        var seedCommand = new SeedCategoryTypesCommand();
        categoryCommandService.handle(seedCommand);
        logger.info("Category types is done.");
    }
}
