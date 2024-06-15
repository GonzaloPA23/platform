package com.farmachinerental.platform.u202212721.inventories.interfaces.rest.resources;

/**
 * ToolResource
 * <p>
 *     This class represents the resource of a tool.
 *     It is used to expose the tool information to the client.
 * </p>
 * @param id
 * @param name
 * @param description
 * @param referenceImageUrl
 * @param rentalPrice
 * @param categoryId
 * @param categoryType
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public record ToolResource(Long id,String name,
                           String description,
                           String referenceImageUrl,
                           Double rentalPrice,
                           Long categoryId,
                           String categoryType) {
}
