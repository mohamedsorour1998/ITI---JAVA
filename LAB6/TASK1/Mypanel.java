
import javax.swing.*; //Importing of the Swing library

public class Mypanel extends JPanel implements Runnable {
    // Creation of a class that extends JPanel and implements Runnable
    public Mypanel() { // Constructor of the class
        Thread t = new Thread(this); // Creation of a new thread, this refers to class (Mypanel)
        t.start(); // Start of the thread
    }

    @Override
    public void paintComponent(java.awt.Graphics g) { // Method that draws the graphics
        super.paintComponent(g);
        g.drawString("Time: " + new java.util.Date(), 10, 20); // Draws a string

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
        }
    }

}
