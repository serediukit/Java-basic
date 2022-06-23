package main.java.com.kpi.model.utilities;

import main.java.com.kpi.model.exceptions.FileNameException;
import main.java.com.kpi.model.exceptions.NumberInputException;
import main.java.com.kpi.model.exceptions.StringInputException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator {
    private static final Pattern stringPattern = Pattern.compile("^[a-zA-Z0-9 -]+$");
    private static final Pattern fileNamePattern = Pattern.compile("^[a-zA-Z0-9_]+\\.ser$");

    public static void checkNum(int a, int left, int right) throws NumberInputException {
        if(a < left || a > right)
            throw new NumberInputException();
    }

    public static void checkString(String str) throws StringInputException {
        Matcher stringMatcher = stringPattern.matcher(str);
        if (!stringMatcher.matches())
            throw new StringInputException();
    }
    public static void checkFileName(String fileName) throws FileNameException {
        Matcher fileNameMatcher = fileNamePattern.matcher(fileName);
        if (!fileNameMatcher.matches())
            throw new FileNameException();
    }

    public static void checkYN(String str) throws StringInputException {
        if(!str.equals("y") && !str.equals("n"))
            throw new StringInputException();
    }
}
