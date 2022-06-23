package com.kpi.controller;

import com.kpi.model.CarsModel;
import com.kpi.model.utilities.FileLoader;
import com.kpi.model.utilities.Validator;
import com.kpi.view.CarsView;
import com.kpi.view.CarsInput;
import com.kpi.model.classes.Car;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class CarsController {

    private final CarsModel model;
    private final CarsView view;
    private final CarsInput input;
    private static final Logger logger = LogManager.getLogger(CarsController.class);

    public CarsController() {
        this.model = new CarsModel();
        this.view = new CarsView();
        this.input = new CarsInput(view);
        logger.info("The program has been started.");
    }

    public void run() {
        int choice;
        int savedFiles = 0;

        try {
            String fileName = input.inputString(view.INPUT_FILE_NAME);
            Validator.checkFileName(fileName);
            model.setCars(FileLoader.load(fileName));
        } catch (Exception e) {
            view.printMessageln(e.getMessage());
            logger.error(e.getMessage(), e);
            System.exit(0);
        }

        if(model.getCars().isEmpty()) {
            view.printMessageln("\nDatabase is empty\nCLosing the program...");
            logger.info("Database is empty. Closing the program.");
            System.exit(0);
        }

        view.printMessageln("\nCars database");
        view.printResult(model.getCars());

        while(true) {
            try {
                ArrayList<Car> resultList = new ArrayList<>();

                view.printMessage(view.INPUT_MESSAGE);
                choice = input.inputValue();
                Validator.checkNum(choice, 1, 5);

                if(choice == 1) {
                    view.printMessageln("BRAND");
                    String brand = input.inputString(view.INPUT_STRING_DATA);
                    Validator.checkString(brand);

                    resultList = model.getByBrand(brand);
                    view.printResult(resultList);

                } else if (choice == 2) {
                    view.printMessageln("MODEL");
                    String models = input.inputString(view.INPUT_STRING_DATA);
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

                } else if (choice == 4) {
                    String endFileName = input.inputString(view.INPUT_FILE_NAME);
                    Validator.checkFileName(endFileName);
                    FileLoader.save(endFileName, model.getCars());

                    view.printMessageln(view.EXIT_PROGRAM);
                    logger.info("The program has been closed");
                    System.exit(0);

                } else {
                    view.printMessageln(view.EXIT_PROGRAM);
                    logger.info("The program has been closed");
                    System.exit(0);

                }

                String choiceYN = input.inputString("Save the result? y/n:");
                Validator.checkYN(choiceYN);
                if(choiceYN.equals("y")) {
                    savedFiles++;
                    FileLoader.save("result" + savedFiles + ".ser", resultList);
                }

            } catch (Exception e) {
                view.printMessageln(e.getMessage());
                logger.error(e.getMessage(), e);
            }
        }
    }
}
