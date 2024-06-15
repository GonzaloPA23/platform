package com.farmachinerental.platform.u202212721.inventories.domain.model.exceptions;

/**
 * ToolWithTheCurrentNameAlreadyExistException
 * <p>
 *     This class represents the exception that is thrown when a tool with the current name already exists.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class ToolWithTheCurrentNameAlreadyExistException extends RuntimeException {
    public ToolWithTheCurrentNameAlreadyExistException(String message) {
        super(message);
    }
}
