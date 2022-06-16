package main.java.com.kpi.view;

import main.java.com.kpi.model.classes.Car;

import java.util.ArrayList;

public class CarsView {
    public static final String INPUT_MESSAGE = "Choose option:\n" +
            "1. Cars by brand\n" +
            "2. Cars by brand and used more than N years\n" +
            "3. Cars by year and price higher than N\n" +
            "---------------------------------------------------\n";
    public static final String INPUT_INT_DATA = "Enter an integer: ";
    public static final String WRONG_INPUT_DATA = "Wrong input!\nRepeat: ";
    public static final String INPUT_STRING_DATA = "Enter string: ";

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessageAndResult(String message, int value) {
        System.out.print(message + value);
    }

    public void printResult(ArrayList<Car> lst) {
        System.out.print(
                "+------------+-----------------+--------------------------------+------+------------+------------+------------+\n" +
                "|     ID     |      BRAND      |             MODEL              | YEAR |   COLOR    | REGNUMBER  |   PRICE    |\n" +
                "+------------+-----------------+--------------------------------+------+------------+------------+------------+\n");
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i).toString());
        }
        System.out.println("+------------+-----------------+--------------------------------+------+------------+------------+------------+\n");
    }

}
