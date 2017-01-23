package main.java;

import exceptions.DivisionByZeroException;
import exceptions.ExceptionOfEverything;
import exceptions.ParamNumberOfBoundException;
import exceptions.UnacceptableSymbolsException;
import jdbc.JdbcCrud;

import java.sql.ResultSet;


/**
 * Created by Alexey on 27.10.2016.
 */
public class LinearCalculator {



    private LinearCalculator() {
    }

    private static class SingletonHelper {
        private static final LinearCalculator SINGLETON = new LinearCalculator();
    }

    public static LinearCalculator getInstance() {
        return LinearCalculator.SingletonHelper.SINGLETON;
    }


    private JdbcCrud repo;

    public void inicializeCrud() {
        if (repo==null) {
            repo = JdbcCrud.getInstance();
            repo.connect("h2Connection");
        }
    }

    public void putIntoDatabase(String data) {
        repo.update(data);
    }

    public ResultSet selectFromResults() {
        return repo.read();
    }

    public static float parseAndCalc(String comand) throws ExceptionOfEverything {
        String[] c;
        float a;
        float b;

        comand = comand.trim();
        try {
            if(comand.lastIndexOf('+') != -1) {
                c = comand.split("\\+");
                pramsNunberChecker(c);
                a = Float.valueOf(c[0]);
                b = Float.valueOf(c[1]);
                return sum(a, b);
            } else if(comand.lastIndexOf('-') != -1) {
                c = comand.split("-");
                pramsNunberChecker(c);
                a = Float.valueOf(c[0]);
                b = Float.valueOf(c[1]);
                return sub(a, b);
            } else if(comand.lastIndexOf('*') != -1) {
                c = comand.split("\\*");
                pramsNunberChecker(c);
                a = Float.valueOf(c[0]);
                b = Float.valueOf(c[1]);
                return mult(a, b);
            } else if(comand.lastIndexOf('/') != -1) {
                c = comand.split("/");
                pramsNunberChecker(c);
                a = Float.valueOf(c[0]);
                b = Float.valueOf(c[1]);
                return degr(a, b);
            }
        } catch (NumberFormatException e) {
            throw new UnacceptableSymbolsException();
        }
        throw new ExceptionOfEverything();
    }

    private static void pramsNunberChecker(String[] c) throws ParamNumberOfBoundException {
        if (c.length != 2)
            throw new ParamNumberOfBoundException();
    }


    private static float sum(float a, float b) {
        return a + b;
    }

    private static float sub(float a, float b) {
        return a - b;
    }

    private static float mult(float a, float b) {
        return a * b;
    }

    private static float degr(float a, float b) throws DivisionByZeroException {
        if(b==0)
            throw new DivisionByZeroException();
        return a / b;
    }

}
