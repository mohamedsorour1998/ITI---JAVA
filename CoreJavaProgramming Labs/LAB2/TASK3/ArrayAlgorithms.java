package LAB2.TASK3;

public class ArrayAlgorithms {
    public int max(int array[]) {
        // return max number in a given array of integers
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int min(int array[]) {
        // return min number in a given array of integers
        int min = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        return min;

    }

    public int binarySearch(int array[], int data) {
        // return index of data in array if found, -1 otherwise
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (array[mid] < data) {
                low = mid + 1;
            } else if (array[mid] == data) {
                return mid;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return -1;

    }

};
