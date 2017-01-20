package exceptions;

/**
 * Created by Alexey on 06.12.2016.
 */
public class ParamNumberOfBoundException extends ExceptionOfEverything {

    @Override
    public String getMessage() {
        return "Not correct number of params.";
    }
}
