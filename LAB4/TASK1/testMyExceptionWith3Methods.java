package LAB4.TASK1;

public class testMyExceptionWith3Methods {
    /**
     * @throws myException
     */
    public void thisWillthrowException1() throws myException {
        int x = 5;
        if (x == 5) {
            throw new myException();
        }
    }

    public void thisWillthrowException2() throws myException {
        int x = 10;
        if (x == 5 | x == 10) {
            throw new myException();
        }
    }

    public void thisWillNotthrowException() throws myException {
        int x = 5;
        if (x == 6) {
            throw new myException();
        }
    }
}