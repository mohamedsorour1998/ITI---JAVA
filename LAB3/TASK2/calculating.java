package TASK2;

import java.util.function.Function;

public class calculating implements Function<Float[], Float[]> {
    @Override
    // Override the apply method
    public Float[] apply(Float[] array) {
        // read the values of a,b,c from the array
        float a = array[0];
        float b = array[1];
        float c = array[2];
        float d = (b * b) - (4 * a * c);
        float x1 = (float) ((-b + Math.sqrt(d)) / (2 * a));
        float x2 = (float) ((-b - Math.sqrt(d)) / (2 * a));
        // converting x1,x2 from float to Float
        Float x1AsO = x1;
        Float x2AsO = x2;
        Float[] arrayOut = { x1AsO, x2AsO };
        return arrayOut;
    }
}
