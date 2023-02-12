package TASK2;

import java.util.Scanner;

public class quadraticEquation {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // x2-5x-14=0 [Answer: x=7 & x=-2 ]
        // read the value of a,b,c from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of a: ");
        float a = input.nextFloat();
        System.out.println("Enter the value of b: ");
        float b = input.nextFloat();
        System.out.println("Enter the value of c: ");
        final float c = input.nextFloat();
        // converting a,b,c from float to Float
        Float aAsO = a;
        Float bAsO = b;
        Float cAsO = c;
        // created an array of objects and giving it values at the same time
        Float[] array = { aAsO, bAsO, cAsO };
        // created an object of the class calculating
        Float[] arrayOut = new calculating().apply(array);
        System.out.println("The value of x1 is: " + arrayOut[0]);
        System.out.println("The value of x2 is: " + arrayOut[1]);
        input.close();
    }

}
