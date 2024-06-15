package com.farmachinerental.platform.u202212721.inventories.interfaces.rest.transform;

import com.farmachinerental.platform.u202212721.inventories.domain.model.aggregates.Tool;
import com.farmachinerental.platform.u202212721.inventories.interfaces.rest.resources.ToolResource;

/**
 * Assembler class to convert Tool entity to ToolResource
 * <p>
 *     This class is used to convert Tool entity to ToolResource
 *     which is used to send response in REST API.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class ToolResourceFromEntityAssembler {

    public static ToolResource toResourceFromEntity(Tool tool) {
        return new ToolResource(tool.getId(),
                tool.getName(),
                tool.getDescription(),
                tool.getReferenceImageUrl(),tool.getRentalPrice(),
           tool.getCategory().getId(), tool.getCategory().getType().name().toLowerCase());
    }
}
