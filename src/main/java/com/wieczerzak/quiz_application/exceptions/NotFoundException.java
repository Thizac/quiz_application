package com.wieczerzak.quiz_application.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Element not found ");
    }

}
