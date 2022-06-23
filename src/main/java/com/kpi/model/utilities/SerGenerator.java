package com.kpi.model.utilities;

import com.kpi.model.classes.Car;

import java.util.ArrayList;
import java.io.*;

public class SerGenerator {

    public static void main(String[] args) {
        ArrayList<Car> lst = RandInput.getInput();

        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/res/database.ser");
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));

            oos.writeObject(lst);
            oos.close();
            fos.close();

            System.out.println("Data was successful saved into database.ser");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
