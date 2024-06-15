package com.farmachinerental.platform.u202212721.inventories.domain.services;

import com.farmachinerental.platform.u202212721.inventories.domain.model.aggregates.Tool;
import com.farmachinerental.platform.u202212721.inventories.domain.model.commands.CreateToolCommand;

import java.util.Optional;

/**
 * Category command service interface.
 * <p>
 *     This interface provides methods for handling category commands.
 *     Defines the contract for category command service
 *     Uses Dependency injection for follow the interface segregation principle
 * </p>
 *
 * @author  U202212721 Mathias Jave Diaz
 * @version  1.0
 */
public interface ToolCommandService {
    Optional<Tool> handle(CreateToolCommand command);
}
