package com.farmachinerental.platform.u202212721.inventories.interfaces.rest.resources;

/**
 * Create tool resource
 * <p>
 *     Represents a resource to create a tool in inventory bounded context
 * </p>
 * @param name
 * @param description
 * @param referenceImageUrl
 * @param rentalPrice
 * @param categoryId
 * @author  U20221721 Mathias Jave Diaz
 * @version  1.0
 */
public record CreateToolResource(String name,
                                 String description,
                                 String referenceImageUrl,
                                 Double rentalPrice,
                                 Long categoryId) {
}
