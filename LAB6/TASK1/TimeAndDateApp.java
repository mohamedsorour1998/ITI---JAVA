
/**
 * TimeAndDateApp
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TimeAndDateApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Time and Date");
        frame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawString("Time: " + new java.util.Date(), 10, 20);
            }
        });
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}