package a9527.exception;

/**
 * thrown when the parameters of a command is not in expected format.
 */
public class A9527CommandParamException extends A9527Exception {
    /**
     * Constructs an exception with a message.
     * @param message error message
     */
    public A9527CommandParamException(String message) {
        super(message);
    }
}
