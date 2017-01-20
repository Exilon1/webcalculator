package exceptions;

/**
 * Created by Alexey on 28.10.2016.
 */
public class UnacceptableSymbolsException extends ExceptionOfEverything {

    @Override
    public String getMessage() {
        return "You entered invalid characters.";
    }
}
