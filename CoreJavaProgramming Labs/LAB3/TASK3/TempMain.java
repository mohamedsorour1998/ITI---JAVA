package TASK3;

import java.util.function.Function;

/**
 * TempMain
 */
public class TempMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        float x = 24;
        float out = new Function<Float, Float>() {
            @Override
            public Float apply(Float x) {
                float xAsP = x;
                float xInFP = (float) ((xAsP * 1.8) + 32);
                Float xInFO = xInFP;
                return xInFO;
            }
        }.apply(x);
        System.out.println("temp is: " + x + "c or " + out + "f");
    }
}