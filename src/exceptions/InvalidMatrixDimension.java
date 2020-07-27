package exceptions;

/**
 * @author Yordan Petrov
 */


public class InvalidMatrixDimension extends RuntimeException {

    public InvalidMatrixDimension() {
    }

    public InvalidMatrixDimension(String message) {
        super(message);
    }

    public InvalidMatrixDimension(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMatrixDimension(Throwable cause) {
        super(cause);
    }
}