package exceptions;

/**
 * Created by Alexey on 06.12.2016.
 */
public class ExceptionOfEverything extends Exception {

    @Override
    public String getMessage() {
        return "O shit! What is going on??";
    }
}
