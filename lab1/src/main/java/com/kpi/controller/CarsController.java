package main.java.com.kpi.controller;

import main.java.com.kpi.model.CarsModel;
import main.java.com.kpi.view.CarsView;
import main.java.com.kpi.view.CarsInput;
import main.java.com.kpi.model.classes.Car;
import main.java.com.kpi.model.utilities.RandInput;

import java.util.ArrayList;
//import java.util.Scanner;

public class CarsController {

    private final CarsModel model;
    private final CarsView view;
    private final CarsInput input;

    public CarsController() {
        this.model = new CarsModel();
        this.view = new CarsView();
        this.input = new CarsInput(view);
    }

    public void run() {
        int choice = 0;
        ArrayList<Car> carList = new ArrayList<>();
        carList = RandInput.getInput();
        view.printMessageln("Cars database");
        view.printResult(carList);

        while(true) {
            ArrayList<Car> resultList = new ArrayList<>();

            view.printMessage(view.INPUT_MESSAGE);
            choice = input.inputValue(view);

            if(choice == 1) {
                view.printMessageln("BRAND");
                String brand = input.inputString(view);

                resultList = model.getByBrand(carList, brand);
                view.printResult(resultList);
            } else if (choice == 2) {
                view.printMessageln("MODEL");
                String models = input.inputString(view);

                view.printMessageln("YEARS");
                int year = input.inputValue(view);

                resultList = model.getByModelAndYears(carList, models, year);
                view.printResult(resultList);
            } else if (choice == 3) {
                view.printMessageln("YEAR");
                int year = input.inputValue(view);

                view.printMessageln("PRICE");
                int price = input.inputValue(view);

                resultList = model.getByYearAndPrice(carList, year, price);
                view.printResult(resultList);
            } else if (choice == 4) {
                System.exit(0);
            } else {
                view.printMessage("There is no command for this number");
            }
        }
    }
}
