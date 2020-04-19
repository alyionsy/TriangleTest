package by.bsu.company.triangle.exception;

public class TriangleCheckException extends Exception {
    public TriangleCheckException() {
    }

    public TriangleCheckException(String message) {
        super(message);
    }

    public TriangleCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleCheckException(Throwable cause) {
        super(cause);
    }

    public TriangleCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
