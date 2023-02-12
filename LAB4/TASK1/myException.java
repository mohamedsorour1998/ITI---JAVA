package LAB4.TASK1;

/**
 * Exception
 */
public class myException extends Exception {
    public myException() {
    super("this is my own exception form the constructor");
    }

    @Override
    public String getMessage() {
        return "this is my own exception";
    }

}
