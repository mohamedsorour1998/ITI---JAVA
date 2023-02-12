package TASK1;

import java.util.function.Function;

/**
 * TemperatureConvert
 */
public class TemperatureConvert implements Function<Float, Float> {
    @Override
    public Float apply(Float x) {
        float xAsP = x;
        float xInFP = (float) ((xAsP * 1.8) + 32);
        Float xInFO = xInFP;
        return xInFO;
    }

}
