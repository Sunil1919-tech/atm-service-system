package com.bridgelabz.atmproject.exception;

/**
 * Purpose: to describe Entity not found exception
 *
 * @author Sunil
 * @since 03/12/2021
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
