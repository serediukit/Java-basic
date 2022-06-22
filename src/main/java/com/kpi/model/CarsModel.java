package main.java.com.kpi.model;

import main.java.com.kpi.model.classes.Car;

import java.util.ArrayList;
import java.util.Calendar;

public class CarsModel {
    private ArrayList<Car> cars = new ArrayList<>();

    public CarsModel() {

    }

    public void setCars(ArrayList<Car> temp) {
        cars = temp;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Car> getByBrand(String brand) {
        ArrayList<Car> lst = new ArrayList<>();
        for (int i = 0 ; i < cars.size(); i++) {
            if(cars.get(i).getBrand().equalsIgnoreCase(brand)) {
                lst.add(cars.get(i));
            }
        }
        return lst;
    }

    public ArrayList<Car> getByModelAndYears(String model, int year) {
        ArrayList<Car> lst = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (int i = 0 ; i < cars.size(); i++) {
            if(cars.get(i).getModel().equalsIgnoreCase(model) && cars.get(i).getYear() < cal.get(Calendar.YEAR) - year) {
                lst.add(cars.get(i));
            }
        }
        return lst;
    }

    public ArrayList<Car> getByYearAndPrice(int year, int price) {
        ArrayList<Car> lst = new ArrayList<>();
        for (int i = 0 ; i < cars.size(); i++) {
            if(cars.get(i).getYear() == year && cars.get(i).getPrice() > price) {
                lst.add(cars.get(i));
            }
        }
        return lst;
    }
}
