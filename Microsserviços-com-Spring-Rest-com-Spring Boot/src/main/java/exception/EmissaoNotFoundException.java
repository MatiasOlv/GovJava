package exception;

public class EmissaoNotFoundException extends RuntimeException {
    public EmissaoNotFoundException(String message) {
        super(message);
    }
}
