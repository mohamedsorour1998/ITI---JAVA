
import javax.swing.*; //Importing of the Swing library

public class Mypanel extends JPanel implements Runnable {
    // Creation of a class that extends JPanel and implements Runnable
    int dx = 25;
    int x = 5;

    public Mypanel() { // Constructor of the class
        Thread t = new Thread(this); // Creation of a new thread, this refers to class (Mypanel)
        t.start(); // Start of the thread
    }

    @Override
    public void paintComponent(java.awt.Graphics g) { // Method that draws the graphics
        super.paintComponent(g);
        // draw string "marquee"
        g.drawString("I'am a Marquee Text!", x, 50);
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
            // if the x position is less than the frame width, increment x by dx
            // otherwise, reset x to 5

            if (x < frameWidth) {
                x = x + dx;

            } else {
                x = 5;

            }

        }
    }

}
