package main.java.com.kpi.model.utilities;

import main.java.com.kpi.model.classes.Car;
import main.java.com.kpi.view.CarsView;
import main.java.com.kpi.model.exceptions.FileLoadException;

import java.util.ArrayList;
import java.io.*;

public class FileLoader {
    private static final String FILE_PATH = "src/main/java/res/";

    public FileLoader() {

    }

    public static ArrayList<Car> load(String filename) {
        ArrayList<Car> lst = new ArrayList<>();

        try {
            ObjectInputStream fistream = new ObjectInputStream(new FileInputStream(FILE_PATH + filename));
            lst = (ArrayList<Car>) fistream.readObject();
        } catch (IOException e) {
            CarsView.printMessageln(e.getMessage());
        } catch (ClassNotFoundException e) {
            CarsView.printMessageln(e.getMessage());
        }

        return lst;
    }

    public static void save(String filename, String info) {
        try (FileWriter fostream = new FileWriter(filename)) {
            fostream.write(info);
            fostream.flush();
            CarsView.printMessageln(CarsView.SAVE_FILE);
            CarsView.printMessageln("File location: " + FILE_PATH + filename);
        } catch (IOException e) {
            CarsView.printMessageln(e.getMessage());
        }
    }
}
