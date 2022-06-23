package com.kpi.model.exceptions;

public class NumberInputException extends Exception {

    public NumberInputException() {
        super("Wrong number! Trying again... ");
    }
}
