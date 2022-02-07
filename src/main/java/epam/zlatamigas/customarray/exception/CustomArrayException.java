package epam.zlatamigas.customarray.exception;

public class CustomArrayException extends Exception {

    public CustomArrayException() {
        super();
    }

    public CustomArrayException(String message) {
        super(message);
    }

    public CustomArrayException(Throwable cause) {
        super(cause);
    }

    public CustomArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}
