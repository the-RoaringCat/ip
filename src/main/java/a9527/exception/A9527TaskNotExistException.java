package a9527.exception;

/**
 * thrown when a task is not found.
 */
public class A9527TaskNotExistException extends A9527Exception {
    /**
     * Constructs an exception with a message.
     * @param message error message
     */
    public A9527TaskNotExistException(String message) {
        super(message);
    }
}
