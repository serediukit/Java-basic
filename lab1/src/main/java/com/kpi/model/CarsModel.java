package main.java.com.kpi.model;

import main.java.com.kpi.model.classes.Car;

import java.util.ArrayList;
import java.util.Calendar;

public class CarsModel {
    public CarsModel() {

    }

    public ArrayList<Car> getByBrand(ArrayList<Car> temp, String brand) {
        ArrayList<Car> lst = new ArrayList<>();
        for (int i = 0 ; i < temp.size(); i++) {
            if(temp.get(i).getBrand().equalsIgnoreCase(brand)) {
                lst.add(temp.get(i));
            }
        }
        return lst;
    }

    public ArrayList<Car> getByModelAndYears(ArrayList<Car> temp, String model, int year) {
        ArrayList<Car> lst = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (int i = 0 ; i < temp.size(); i++) {
            if(temp.get(i).getModel().equalsIgnoreCase(model) && temp.get(i).getYear() < cal.get(Calendar.YEAR) - year) {
                lst.add(temp.get(i));
            }
        }
        return lst;
    }

    public ArrayList<Car> getByYearAndPrice(ArrayList<Car> temp, int year, int price) {
        ArrayList<Car> lst = new ArrayList<>();
        for (int i = 0 ; i < temp.size(); i++) {
            if(temp.get(i).getYear() == year && temp.get(i).getPrice() > price) {
                lst.add(temp.get(i));
            }
        }
        return lst;
    }
}
