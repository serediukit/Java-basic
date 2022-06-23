package com.kpi.model.utilities;

import com.kpi.model.classes.Car;
import com.kpi.view.CarsView;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.io.*;

public class FileLoader {
    private static final String FILE_PATH = "src/main/java/res/";
    private static final Logger logger = LogManager.getLogger(FileLoader.class);

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
            CarsView.printMessageln("Closing the program...");
            logger.error("File can't to be read.");
            System.exit(0);
        } catch (ClassNotFoundException e) {
            CarsView.printMessageln(e.getMessage());
            CarsView.printMessageln("CLosing the program...");
            logger.error("Data can't be deserialized.");
            System.exit(0);
        }
        logger.info("File \"" + fileName + "\" was successfully loaded");

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
            logger.error("Data can't be saved.");
            e.printStackTrace();
        }
        logger.info("File \"" + fileName + "\" was successfully saved");
    }
}
