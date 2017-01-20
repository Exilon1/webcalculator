import exceptions.DivisionByZeroException;
import exceptions.ExceptionOfEverything;
import exceptions.ParamNumberOfBoundException;
import exceptions.UnacceptableSymbolsException;

import java.util.Scanner;

/**
 * Created by Alexey on 27.10.2016.
 */
public class LinearCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Good evening, professor!\n" +
                "What would you like to calculate?\n" +
                "(if you don't know to do use command help)");
     //   System.out.println(Float.valueOf("sum"));
        String comand;
        while(scanner.hasNext()) {
            comand = scanner.nextLine();
            comand = comand.trim();

            if(comand.equals("help"))
                System.out.println("you have access to the command\n" +
                        "a+b\n" +
                        "a-b\n" +
                        "a*b\n" +
                        "a/b\n");
            float c;
            try {
                try {
                    c = parseAndCalc(comand);
                    System.out.println("Result: " + c);
                } catch (ParamNumberOfBoundException | UnacceptableSymbolsException | DivisionByZeroException e) {
                    System.out.println(e.getMessage());
                }
            } catch (ExceptionOfEverything e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static float parseAndCalc(String comand) throws ExceptionOfEverything {
        String[] c;
        float a;
        float b;

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
