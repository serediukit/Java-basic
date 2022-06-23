package main.java.com.kpi.model.utilities;

import main.java.com.kpi.model.classes.Car;
import main.java.com.kpi.view.CarsView;

import java.util.ArrayList;
import java.io.*;

public class FileLoader {
    private static final String FILE_PATH = "src/main/java/res/";

    public FileLoader() {

    }

    public static ArrayList<Car> load(String fileName) {
        ArrayList<Car> lst = new ArrayList<>();

        try {
            ObjectInputStream fistream = new ObjectInputStream(new FileInputStream(FILE_PATH + fileName));
            lst = (ArrayList<Car>) fistream.readObject();
            fistream.close();
        } catch (IOException e) {
            CarsView.printMessageln(e.getMessage());
            CarsView.printMessageln("CLosing the program...");
            System.exit(0);
        } catch (ClassNotFoundException e) {
            CarsView.printMessageln(e.getMessage());
            CarsView.printMessageln("CLosing the program...");
            System.exit(0);
        }

        return lst;
    }

    public static void save(String fileName, ArrayList<Car> lst) {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH + fileName);
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));

            oos.writeObject(lst);
            oos.close();
            fos.close();

            System.out.println(CarsView.SAVE_FILE + fileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
