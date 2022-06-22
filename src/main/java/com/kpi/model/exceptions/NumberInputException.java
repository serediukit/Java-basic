package main.java.com.kpi.model.exceptions;

public class NumberInputException extends Exception {

    public NumberInputException() {
        super("Wrong number! Try again: ");
    }
}
