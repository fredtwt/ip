package doge.exception;

public class DogeException extends Exception {
    private String message;
    /**
     * Constructor for DogeException class.
     * @param s the exception message
     */
    public DogeException(String s) {
        super(s);
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
