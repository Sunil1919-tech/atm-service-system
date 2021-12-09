package com.bridgelabz.atmproject.exception;

import com.bridgelabz.atmproject.dto.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Purpose: This class is to handle the exceptions using controller advice
 *
 * @author Sunil
 * @since 03/12/2021
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * purpose: method to handle the different Global exceptions
     *
     * @param exception: for not valid exception
     * @param headers:   used to describe the Http messages
     * @param status:    describe the http status code
     * @return exception and status of the body
     */
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                               HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("Status", status.value());

        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }

    /**
     * Purpose: method to define the exception message for methods
     *
     * @param exception: the class to throw the message for the method level exception
     * @param request:   current webRequest
     * @return: new response entity
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleNotFoundException(EntityNotFoundException exception, WebRequest request) {
        ResponseDTO responseDTO = new ResponseDTO(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Purpose: to define the constraint exception message for server error
     *
     * @param sqlIntegrityConstraintViolationException
     * @param request:       webRequest
     * @return: new response entity of that instance
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseDTO> handleConstraintViolationException(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException, WebRequest request) {
        ResponseDTO responseDTO = new ResponseDTO(new Date(), sqlIntegrityConstraintViolationException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
