
/**
 * TimeAndDateApp
 * 
 * This program displays the current time and date in a window 
 * on the screen. 
 */
import javax.swing.*;

public class TimeAndDateApp {

    /**
     * This is the main method that creates the window and displays
     * the current time and date.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Time and Date");
        frame.setContentPane(new Mypanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}