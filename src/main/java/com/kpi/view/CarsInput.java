package main.java.com.kpi.view;


import java.util.Scanner;

public class CarsInput {
    private static CarsView view;

    public CarsInput(CarsView view) {
        this.view = view;
    }

    public static int inputValue() {
        Scanner sc = new Scanner(System.in);
        view.printMessage(view.INPUT_INT_DATA);
        while(!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_DATA + view.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        view.printMessage(view.INPUT_STRING_DATA);
        while(!sc.hasNextLine()) {
            view.printMessage(view.WRONG_INPUT_DATA + view.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextLine().trim();
    }
}