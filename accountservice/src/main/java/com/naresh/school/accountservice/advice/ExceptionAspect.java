package com.naresh.school.accountservice.advice;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAspect {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map<String, String> handleAPIExceptions(MethodArgumentNotValidException exception){
        return exception.getBindingResult().getFieldErrors().stream()
        .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

}
