package com.wieczerzak.quiz_application.advisers;


import com.wieczerzak.quiz_application.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviser {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiError> handleBindException(HttpServletRequest request, Exception e){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Binding exception", e.getMessage());
        return ResponseEntity
                .status(apiError.getStatus())
                .body(apiError);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(HttpServletRequest request, Exception e){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "NotFoundException", e.getMessage());
        return ResponseEntity
                .status(apiError.getStatus())
                .body(apiError);
    }



}
