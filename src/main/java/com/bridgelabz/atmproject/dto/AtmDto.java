package com.bridgelabz.atmproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Purpose: this pojo class initialized with the atm parameters for validation
 * Validating the variables
 *
 * @author Sunil
 * @since 03/12/2021
 */
@Data
public class AtmDto {

    @NotNull
    @Pattern(regexp = "^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$",
            message = "Not Valid!!, Card Number Should be 16 digits")
    private String cardNumber;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]{3,15}$", message = "Not Valid,minimum Characters should be 3")
    private String cardName;

    @NotNull
    @Pattern(regexp = "^[0-9]{3}$", message = "Invalid..!, CVV should be 3 digits")
    private String cvv;

}
