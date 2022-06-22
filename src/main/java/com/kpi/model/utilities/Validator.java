package main.java.com.kpi.model.utilities;

import main.java.com.kpi.model.exceptions.NumberInputException;
import main.java.com.kpi.model.exceptions.StringInputException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator {
    private static Pattern stringPattern;
    private static Matcher stringMatcher;

    public Validator() {
        stringPattern = Pattern.compile("^[a-zA-z]+$");
    }

    public static void checkNum(float a, float left, float right) throws NumberInputException {
        if(a < left || a > right)
            throw new NumberInputException();
    }

    public static void checkString(String str) throws StringInputException {
        stringMatcher = stringPattern.matcher(str);
        if (!stringMatcher.matches())
            throw new StringInputException();
    }
}
