package com.kpi.view;

import com.kpi.model.classes.Car;

import java.util.ArrayList;

public class CarsView {
    public static final String INPUT_MESSAGE = "\n\nChoose option:\n" +
            "1. Cars by brand\n" +
            "2. Cars by model and used more than N years\n" +
            "3. Cars by year and price higher than N\n" +
            "4. Save database to the file and exit\n" +
            "5. Exit\n" +
            "---------------------------------------------------\n";
    public static final String INPUT_INT_DATA = "Enter an integer: ";
    public static final String WRONG_INPUT_DATA = "Wrong input!\nRepeat: ";
    public static final String INPUT_STRING_DATA = "Enter string: ";
    public static final String HEADER_OUTPUT = "+------------+-----------------+--------------------------------+------+------------+------------+------------+\n" +
            "|     ID     |      BRAND      |             MODEL              | YEAR |   COLOR    | REGNUMBER  |   PRICE    |\n" +
            "+------------+-----------------+--------------------------------+------+------------+------------+------------+\n";
    public static final String FOOTER_OUTPUT = "+------------+-----------------+--------------------------------+------+------------+------------+------------+\n";
    public static final String INPUT_FILE_NAME = "Enter file name: ";
    public static final String SAVE_FILE = "Data was successfully saved into ";
    public static final String EXIT_PROGRAM = "Closing the program...";


    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printMessageln(String message) {
        System.out.println(message);
    }

    public static void printResult(ArrayList<Car> lst) {
        System.out.print(HEADER_OUTPUT);
        for (Car car : lst) {
            System.out.println(car);
        }
        System.out.println(FOOTER_OUTPUT);
    }

}
