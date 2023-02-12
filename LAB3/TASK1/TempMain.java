package TASK1;

/**
 * TempMain
 */
public class TempMain {

    public static void main(String[] args) {
        float x = 24;
        Float xAsO = x;
        Float yAsO = new TemperatureConvert().apply(xAsO);
        float y = yAsO;
        System.out.println("temp is: " + x + "c or " + y + "f");
    }
}