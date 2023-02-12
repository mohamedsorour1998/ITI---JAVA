
package com.example;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * App
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // create a Text node
        Text t = new Text("Hello World!");
        // create a Rectangle node
        Rectangle r1 = new Rectangle(500, 500);
        // create a Reflection effect
        Reflection r = new Reflection();
        // set an id for the Text node
        t.setId("hello-text");
        // set an id for the Rectangle node
        r1.setId("hello-rect");
        // apply the Reflection effect to the Text node
        t.setEffect(r);
        // set the fraction of the Reflection effect
        r.setFraction(0.7f);

        // Create a new StackPane
        StackPane pane = new StackPane();
        // Add the Rectangle to the StackPane
        pane.getChildren().add(r1);
        // Add the Text to the StackPane
        pane.getChildren().add(t);
        Scene scene = new Scene(pane, 500, 500);
        // add style.css file to scene
        scene.getStylesheets().add(new File(
                "/mnt/hgfs/ITI IoT Intake 43 Materials/JAVA/LABS/GUI JAVAFX Labs/LAB1/TASK1/helloworld/src/main/resources/style.css")
                .toURI().toString());
        primaryStage.setTitle("Hello World!"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    public static void main(String[] args) {
        launch(args);
    }

}
