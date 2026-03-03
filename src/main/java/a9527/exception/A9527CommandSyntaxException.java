package a9527.exception;

/**
 * thrown when the command syntax(grammar) is wrong
 */
public class A9527CommandSyntaxException extends A9527Exception {
    /**
     * Constructs an exception with a message.
     * @param message error message
     */
    public A9527CommandSyntaxException(String message) {
        super(message);
    }
}
