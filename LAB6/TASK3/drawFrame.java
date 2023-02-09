
//import the swing class
import javax.swing.*;

public class drawFrame {

    public void draw() {
        // create a frame
        JFrame frame = new JFrame();
        // set the size of the frame
        frame.setSize(500, 500);
        // set the title of the frame
        frame.setTitle("Bouncing Ball App");
        // set the content pane of the frame
        frame.setContentPane(new Mypanel());
        // set the frame visible
        frame.setVisible(true);
        // set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
