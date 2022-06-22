package main.java.com.kpi.model.utilities;

import main.java.com.kpi.model.classes.Car;

import java.util.ArrayList;

public class RandInput {
    public static ArrayList<Car> getInput() {
        ArrayList<Car> lst = new ArrayList<>();

        Car temp1 = new Car("1349394239",
                "Mercedes",
                "C200",
                2001,
                "silver",
                "0321321092",
                9500);
        lst.add(temp1);

        Car temp2 = new Car("4219321898",
                "Volkswagen",
                "Golf V",
                2004,
                "gray",
                "4324909123",
                5100);
        lst.add(temp2);

        Car temp3 = new Car("2310293212",
                "Skoda",
                "Octavia",
                2016,
                "white",
                "3123921380",
                14800);
        lst.add(temp3);

        Car temp4 = new Car("5023459345",
                "ZAZ",
                "Tavria",
                2003,
                "blue",
                "8534909234",
                1200);
        lst.add(temp4);

        Car temp5 = new Car("8592340934",
                "Volkswagen",
                "Passat B7",
                2012,
                "brown",
                "8942301923",
                14200);
        lst.add(temp5);

        Car temp6 = new Car("5634789234",
                "BMW",
                "X5",
                2014,
                "gray",
                "6783249832",
                29500);
        lst.add(temp6);

        Car temp7 = new Car("8423931230",
                "Volkswagen",
                "Tiguan",
                2008,
                "black",
                "5432798132",
                11200);
        lst.add(temp7);

        Car temp8 = new Car("4327849823",
                "BMW",
                "320 F30",
                2013,
                "orange",
                "4632712378",
                18000);
        lst.add(temp8);

        Car temp9 = new Car("6432712389",
                "Toyota",
                "Camry",
                2018,
                "silver",
                "3219909902",
                22700);
        lst.add(temp9);

        Car temp10 = new Car("0239139219",
                "Porsche",
                "Cayenne S",
                2014,
                "brown",
                "6583249812",
                10000);
        lst.add(temp10);

        return lst;
    }
}
