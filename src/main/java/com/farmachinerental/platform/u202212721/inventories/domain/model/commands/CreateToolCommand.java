package com.farmachinerental.platform.u202212721.inventories.domain.model.commands;

/**
 * Create tool command
 * <p>
 *     Represents a command to create a tool in inventory bounded context
 *     Declares as record for immutability
 * </p>
 * @param name
 * @param description
 * @param referenceImageUrl
 * @param rentalPrice
 * @param categoryId
 * @author  U20221721 Mathias Jave Diaz
 * @version  1.0
 */
public record CreateToolCommand(String name, String description, String referenceImageUrl, Double rentalPrice, Long categoryId) {
}
