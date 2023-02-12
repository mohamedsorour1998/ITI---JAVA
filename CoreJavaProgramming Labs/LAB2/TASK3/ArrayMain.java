package LAB2.TASK3;

/**
 * ArrayMain
 */
public class ArrayMain {

    public static void main(String[] args) {
        // an array of 1000 random numbers
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        ArrayAlgorithms m = new ArrayAlgorithms();
        System.out.println("Max value in array is: " + m.max(array));
        System.out.println("Min value in array is: " + m.min(array));
        // calculate time take to preform binarySearch using system nano time
        long startTime = System.nanoTime();
        m.binarySearch(array, 999);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.out.println("Time taken to binarySearch is: " + duration + " milliseconds");

    }
}