package exceptions;

/**
 * @author Yordan Petrov
 */


public class InvalidConsoleInputException extends RuntimeException {

    public InvalidConsoleInputException() {
    }

    public InvalidConsoleInputException(final String message) {
        super(message);
    }

    public InvalidConsoleInputException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidConsoleInputException(final Throwable cause) {
        super(cause);
    }
}