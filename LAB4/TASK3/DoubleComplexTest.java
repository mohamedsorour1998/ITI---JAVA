public class DoubleComplexTest {
    public static void main(String[] args) {
        DoubleComplex No1 = new DoubleComplex(5, 2);
        DoubleComplex No2 = new DoubleComplex(7, 3);
        System.out.println(No1.add(No2));
        System.out.println(No1.subtract(No2));
        System.out.println(No1.product(No2));
        System.out.println(No1.div(No2));
    }
}
