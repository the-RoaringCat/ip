package a9527.exception;

/**
 * thrown when error related to A9527 chatbot occurs
 */
public class A9527Exception extends Exception{
    /**
     * Constructs an exception.
     */
    public A9527Exception() {
    }
    /**
     * Constructs an exception with a message.
     * @param message error message
     */
    public A9527Exception(String message) {
        super(message);
    }

}
