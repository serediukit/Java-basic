package main.java.com.kpi.model;

import main.java.com.kpi.model.classes.Car;
import main.java.com.kpi.view.CarsView;

import java.util.ArrayList;
import java.util.stream.Collectors;
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
        return cars.stream()
                .filter(cars -> cars.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Car> getByModelAndYears(String model, int year) {
        Calendar cal = Calendar.getInstance();
        return cars.stream()
                .filter(cars -> cars.getModel().equalsIgnoreCase(model) && cars.getYear() < cal.get(Calendar.YEAR) - year)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Car> getByYearAndPrice(int year, int price) {
        return cars.stream()
                .filter(cars -> cars.getYear() == year && cars.getPrice() > price)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public String generateInfo(ArrayList<Car> lst) {
        String str = new String();
        str += CarsView.HEADER_OUTPUT;
        for(Car car : lst) {
            str += car.toString();
            str += "\n";
        }
        str += CarsView.FOOTER_OUTPUT;

        return str;
    }
}
