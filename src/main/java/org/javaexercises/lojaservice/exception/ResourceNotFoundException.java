package org.javaexercises.lojaservice.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String detail) {
        super(detail);
    }
}