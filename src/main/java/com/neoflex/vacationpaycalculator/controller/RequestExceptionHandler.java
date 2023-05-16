package com.neoflex.vacationpaycalculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.neoflex.vacationpaycalculator.exception.DataForCalculationNullException;


@RestControllerAdvice
public class RequestExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataForCalculationNullException.class)
    public String valueNotFound(DataForCalculationNullException e) {
        return e.getMessage();
    }
}
