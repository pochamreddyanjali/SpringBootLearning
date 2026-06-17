package com.example.fooddemo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidException(MethodArgumentNotValidException ex)
    {
    	Map<String,String> errors=new HashMap<>();
    	ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
    	return errors;
    	
    }
}
