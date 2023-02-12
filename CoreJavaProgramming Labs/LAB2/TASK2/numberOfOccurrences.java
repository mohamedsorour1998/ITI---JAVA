/**
 * numberOfOccurrences
 */
public class numberOfOccurrences {
    public static void main(String[] args) {
        int counter = 0;
        String sen = "hello from egypt !";
        String wor = "egypt";
        // converting sen into array
        String[] senArray = sen.split(" ");
        for (int i = 0; i < senArray.length; i++) {
            // String is a class e.g. references data type, so we have used equals to.
            if (senArray[i].equals(wor)) {
                counter++;
            }
        }
        System.out.print("The number of occurrences of " + wor + " in " + sen + " is " + counter);
        // 2nd way
        // check if wor have the same value of any element of senArray using .contains
        for (int i = 0; i < senArray.length; i++) {
            // String is a class e.g. references data type, so we have used equals to.
            if (senArray[i].contains(sen)) {
                counter++;
            }
        }
        System.out.print("The number of occurrences of " + wor + " in " + sen + " is " + counter);

    }
}