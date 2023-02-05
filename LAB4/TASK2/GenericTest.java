import java.util.*;

public class GenericTest {
    public static void drawShapes(List<? extends Shape> lists) {
        for (Shape s : lists) { // for each shape in the list
            s.draw(); // call draw method in Shape, Circle, or Rect
        }
    }

    public static void main(String[] args) {
        List<Rect> list1 = new ArrayList<Rect>();
        list1.add(new Rect());

        List<Circle> list2 = new ArrayList<Circle>();
        list2.add(new Circle());

        drawShapes(list1);
        drawShapes(list2);
    }
}
