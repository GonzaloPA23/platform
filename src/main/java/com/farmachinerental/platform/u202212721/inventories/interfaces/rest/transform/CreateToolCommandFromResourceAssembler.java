package com.farmachinerental.platform.u202212721.inventories.interfaces.rest.transform;

import com.farmachinerental.platform.u202212721.inventories.domain.model.commands.CreateToolCommand;
import com.farmachinerental.platform.u202212721.inventories.interfaces.rest.resources.CreateToolResource;

/**
 * Create tool command from resource assembler
 * <p>
 *     Assembler to transform a create tool resource into a create tool command
 *     in inventory bounded context
 * </p>
 *
 * @author U20221721 Mathias Jave Diaz
 * @version 1.0
 */
public class CreateToolCommandFromResourceAssembler {
    public static CreateToolCommand toCommandFromResource (CreateToolResource resource){
        return new CreateToolCommand(resource.name(), resource.description(), resource.referenceImageUrl(), resource.rentalPrice(),resource.categoryId());

    }
}
