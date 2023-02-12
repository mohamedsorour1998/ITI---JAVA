
import javax.swing.*; //Importing of the Swing library

public class Mypanel extends JPanel implements Runnable {
    // Creation of a class that extends JPanel and implements Runnable
    int dx = 25; // X coordinate for the ball
    int x = 5; // X coordinate for the ball
    int dy = 25; // Y coordinate for the ball
    int y = 200; // Y coordinate for the ball

    public Mypanel() { // Constructor of the class
        Thread t = new Thread(this); // Creation of a new thread, this refers to class (Mypanel)
        t.start(); // Start of the thread
    }

    @Override
    public void paintComponent(java.awt.Graphics g) { // Method that draws the graphics
        super.paintComponent(g);
        // draw a circle with red color
        g.setColor(java.awt.Color.RED);
        g.fillOval(x, y, 50, 50);
        g.drawOval(x, y, 50, 50);

    }

    @Override
    public void run() { // Method that runs
        while (true) { // Infinite loop
            try {
                Thread.sleep(1000); // Halt the thread for 1000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint(); // Calls the paintComponent method
            // get the current frame width
            int frameWidth = this.getWidth();
            // get the current frame hight
            int frameHight = this.getHeight();

            // make the ball start move from the middle of the left frame to the middle of
            // the top frame then bounce back
            // to the middle of the right frame then bounce back to the middle of the bottom
            // frame and so on
            if (x + dx > frameWidth - 50 || x + dx < 0) {
                dx = -dx;
            }
            if (y + dy > frameHight - 50 || y + dy < 0) {
                dy = -dy;
            }
            x = x + dx;
            y = y + dy;

        }
    }

}
