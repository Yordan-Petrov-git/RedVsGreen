package exceptions;

/**
 * @author Yordan Petrov
 */


public class InvalidMatrixDimension extends RuntimeException {

    public InvalidMatrixDimension() {
    }

    public InvalidMatrixDimension(final String message) {
        super(message);
    }

    public InvalidMatrixDimension(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidMatrixDimension(final Throwable cause) {
        super(cause);
    }
}