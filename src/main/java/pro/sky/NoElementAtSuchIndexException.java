package pro.sky;

public class NoElementAtSuchIndexException extends RuntimeException {
    public NoElementAtSuchIndexException() {
    }

    public NoElementAtSuchIndexException(String message) {
        super(message);
    }

    public NoElementAtSuchIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoElementAtSuchIndexException(Throwable cause) {
        super(cause);
    }
}
