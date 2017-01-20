package exceptions;

/**
 * Created by Alexey on 28.10.2016.
 */
public class DivisionByZeroException extends ExceptionOfEverything {

    @Override
    public String getMessage() {
        return "You tried to divide by zero.";
    }
}
