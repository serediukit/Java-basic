package com.kpi.model.exceptions;

public class StringInputException extends Exception {

    public StringInputException() {
        super("Wrong string! Trying again... ");
    }
}
