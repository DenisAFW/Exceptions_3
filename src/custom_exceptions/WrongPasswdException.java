package custom_exceptions;

public class WrongPasswdException extends Exception {
    public WrongPasswdException(String message) {
        super(message);
    }

    public WrongPasswdException(String message, Throwable cause) {
        super(message, cause);
    }
}
