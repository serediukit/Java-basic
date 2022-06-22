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
            ArrayList<Car> resultList;

            view.printMessage(view.INPUT_MESSAGE);
            choice = input.inputValue();
            Validator.checkNum(choice, 1, 4);

            if(choice == 1) {
                view.printMessageln("BRAND");
                String brand = input.inputString();

                resultList = model.getByBrand(brand);
                view.printResult(resultList);
            } else if (choice == 2) {
                view.printMessageln("MODEL");
                String models = input.inputString();

                view.printMessageln("YEARS");
                int year = input.inputValue();

                resultList = model.getByModelAndYears(models, year);
                view.printResult(resultList);
            } else if (choice == 3) {
                view.printMessageln("YEAR");
                int year = input.inputValue();

                view.printMessageln("PRICE");
                int price = input.inputValue();

                resultList = model.getByYearAndPrice(year, price);
                view.printResult(resultList);
            } else if (choice == 4) {
                System.exit(0);
            } else {
                view.printMessage("There is no command for this number");
            }
        }
    }
}
