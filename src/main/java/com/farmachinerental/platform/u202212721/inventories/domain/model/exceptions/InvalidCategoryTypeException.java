package com.farmachinerental.platform.u202212721.inventories.domain.model.exceptions;

/**
 * InvalidCategoryTypeException
 * <p>
 *     This class represents an exception that is thrown when the category type is invalid.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class InvalidCategoryTypeException extends RuntimeException{
    public InvalidCategoryTypeException(String message) {
        super(message);
    }
}
