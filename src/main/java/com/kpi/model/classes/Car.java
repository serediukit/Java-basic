package main.java.com.kpi.model.classes;

import java.io.Serializable;

public class Car implements Serializable {
    private String id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String regNumber;
    private int price;

    public Car(String id,
               String brand,
               String model,
               int year,
               String color,
               String regNumber,
               int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.regNumber = regNumber;
        this.price = price;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String format = "| %-10s | %-15s | %-30s | %-4d | %-10s | %-10s | %-10d |";
        return String.format(format, id, brand, model, year, color, regNumber, price);
    }
}
