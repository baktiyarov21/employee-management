package com.arsenbaktiyarov.spring.employees.exception;


public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
