package main.java.com.kpi.controller;

import main.java.com.kpi.model.CarsModel;
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
        int choice = 0;
        ArrayList<Car> carList = new ArrayList<>();
        carList = RandInput.getInput();
        while(true) {
            ArrayList<Car> resultList = new ArrayList<>();
            view.printMessage(view.INPUT_MESSAGE);
            choice = input.inputValue(view);
            if(choice == 1) {
                view.printMessage("BRAND");
                String brand = input.inputString(view);
                resultList = model.getByBrand(carList, brand);
                view.printResult(resultList);
            } else if (choice == 2) {
                view.printMessage("MODEL");
                String model = input.inputString(view);
                view.printMessage("YEARS");
                int year = input.inputValue(view);
                resultList = model.getByModelAndYears(carList, model, year);
                view.printResult(resultList);
            } else if (choice == 3) {
                view.printMessage("YEAR");
                int year = input.inputValue(view);
                view.printMessage("PRICE");
                int price = input.inputValue(view);
                resultList = model.getByYearAndPrice(carList, year, price);
                view.printResult(resultList);
            } else {
                view.printMessage("There is no command for this number");
            }
        }
    }
}
