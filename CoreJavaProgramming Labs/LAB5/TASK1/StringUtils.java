/**
 * StringUtils
 */
public class StringUtils {
    public static String betteString(String s1, String s2, BiPredicate<String, String> p) {
        if (p.test(s1, s2)) {
            return s1;
        } else {
            return s2;
        }
    }

    public static void main(String[] args) {
        String string1 = new String("Hello");
        String string2 = new String("Welcome");
        // create an object from a class that implements BiPredicate interface 
        // and override it's method using lambda
        BiPredicate<String, String> p1 = (s1, s2) -> s1.length() > s2.length();
        BiPredicate<String, String> p2 = (s1, s2) -> true;
        System.out.println(
                betteString(string1, string2, p1));
        System.out.println(
                betteString(string1, string2, p2));
    }
}