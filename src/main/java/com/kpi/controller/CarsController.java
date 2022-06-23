package main.java.com.kpi.controller;

import main.java.com.kpi.model.CarsModel;
import main.java.com.kpi.model.utilities.Validator;
import main.java.com.kpi.view.CarsView;
import main.java.com.kpi.view.CarsInput;
import main.java.com.kpi.model.classes.Car;
import main.java.com.kpi.model.utilities.RandInput;

import java.util.ArrayList;

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
        int choice;
        model.setCars(RandInput.getInput());
        view.printMessageln("\nCars database");
        view.printResult(model.getCars());

        while(true) {
            try {
                ArrayList<Car> resultList;

                view.printMessage(view.INPUT_MESSAGE);
                choice = input.inputValue();
                Validator.checkNum(choice, 1, 4);

                if(choice == 1) {
                    view.printMessageln("BRAND");
                    String brand = input.inputString();
                    Validator.checkString(brand);

                    resultList = model.getByBrand(brand);
                    view.printResult(resultList);
                } else if (choice == 2) {
                    view.printMessageln("MODEL");
                    String models = input.inputString();
                    Validator.checkString(models);

                    view.printMessageln("YEARS");
                    int year = input.inputValue();
                    Validator.checkNum(year, 0, 121);

                    resultList = model.getByModelAndYears(models, year);
                    view.printResult(resultList);
                } else if (choice == 3) {
                    view.printMessageln("YEAR");
                    int year = input.inputValue();
                    Validator.checkNum(year, 1900, 2022);

                    view.printMessageln("PRICE");
                    int price = input.inputValue();
                    Validator.checkNum(price, 1, 1000000000);

                    resultList = model.getByYearAndPrice(year, price);
                    view.printResult(resultList);
                } else {
                    System.exit(0);
                }
            } catch (Exception e) {
                view.printMessageln(e.getMessage());
            }
        }
    }
}
