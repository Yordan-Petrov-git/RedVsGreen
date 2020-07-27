package exceptions;

/**
 * @author Yordan Petrov
 */


public class InvalidConsoleInputException extends RuntimeException {

    public InvalidConsoleInputException() {
    }

    public InvalidConsoleInputException(String message) {
        super(message);
    }

    public InvalidConsoleInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidConsoleInputException(Throwable cause) {
        super(cause);
    }
}