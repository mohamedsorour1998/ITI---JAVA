/**
 * This is the program that creates the frame and draws the text in
 * the frame. The frame is created as a JFrame object, and the text
 * is drawn by drawing a String object in the frame.
 */
public class BouncingBallApp {

    /**
     * This is the main method that creates the window and displays
     * the current time and date.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a drawFrame object
        drawFrame draw = new drawFrame();
        // Call the draw method in the drawFrame object
        draw.draw();
    }

}
