package LAB4.TASK1;

public class callingMethodsUsingTryandCatch {
    /**
     * @param args
     */
    public static void main(String[] args) {
        testMyExceptionWith3Methods test = new testMyExceptionWith3Methods();
        try {
            test.thisWillthrowException1();
            System.out.print("Success!");
        } catch (myException e) {
            System.out.println(e.getMessage());
        }
        try {
            test.thisWillthrowException2();
            System.out.print("Success!");
        } catch (myException e) {
            System.out.println(e.getMessage());
        }
        try {
            test.thisWillNotthrowException();
            System.out.print("Success!");
        } catch (myException e) {
            System.out.println(e.getMessage());
        }
    }
}
