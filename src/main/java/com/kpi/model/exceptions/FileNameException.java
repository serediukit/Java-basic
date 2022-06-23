package com.kpi.model.exceptions;

public class FileNameException extends Exception {

    public FileNameException() {
        super("Filename is incorrect. Closing the program...");
    }
}
