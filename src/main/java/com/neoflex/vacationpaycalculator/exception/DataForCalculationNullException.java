package com.neoflex.vacationpaycalculator.exception;

public class DataForCalculationNullException extends RuntimeException {
    public DataForCalculationNullException() {
        super("contains a null value");
    }
}
