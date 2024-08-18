package com.hotel.userserviceasync.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorMessage> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        CustomErrorMessage message = new CustomErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage() + "samjha kya");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(SomethingWentWrongException.class)
    public ResponseEntity<CustomErrorMessage> somethingWentWrongException(SomethingWentWrongException exception, WebRequest request) {
        CustomErrorMessage message = new CustomErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<CustomErrorMessage> exception(MethodArgumentTypeMismatchException exception, WebRequest request) {
        CustomErrorMessage message = new CustomErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}
