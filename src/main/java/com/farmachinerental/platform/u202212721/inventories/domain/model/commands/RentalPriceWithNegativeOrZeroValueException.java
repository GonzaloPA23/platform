package com.farmachinerental.platform.u202212721.inventories.domain.model.commands;

/**
 * RentalPriceWithNegativeOrZeroValueException
 * <p>
 *     This class is used to handle the exception when the rental price is less than 0.
 * </p>
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class RentalPriceWithNegativeOrZeroValueException extends RuntimeException{
    public RentalPriceWithNegativeOrZeroValueException(String message) {
        super(message);
    }
}
