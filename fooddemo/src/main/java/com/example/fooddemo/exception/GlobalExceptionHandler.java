package com.example.fooddemo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException ex)
    {
        return ex.getMessage();
    }
    @ExceptionHandler(NameNotFoundException.class)
    public String handleNameNotFound(NameNotFoundException ex)
    {
    	return ex.getMessage();
    }
}
