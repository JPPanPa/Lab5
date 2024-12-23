package hust.soict.dsai.aims.exception;

public class PlayerException extends Exception {
    private String errorMessage;

    public PlayerException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}