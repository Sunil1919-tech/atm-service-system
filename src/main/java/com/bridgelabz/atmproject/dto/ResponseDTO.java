package com.bridgelabz.atmproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * purpose: to initialize the response variables to define the error details.
 *
 * @author Sunil
 * @since 03/12/2021
 */
@Setter
@Getter
public class ResponseDTO {
    private  String message;
    private String details;
    private Date timestamp;

    public ResponseDTO(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
