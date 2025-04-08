package com.example.SubmersibleProbe.exception;

import org.apache.groovy.json.internal.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorObject> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setErrorMessage(ex.getMessage());
        errorObject.setStatusCode(Constant.BAD_REQUEST);
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
