package by.training.text.vocabulary.exceptions;

public class TextFormatException extends Exception {
    public TextFormatException() {
    }

    public TextFormatException(String message) {
        super(message);
    }

    public TextFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
