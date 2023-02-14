package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

/**
 * JavaFX App
 * notepad
 * Developed
 * by soRouR!
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        MenuBar bar = new MenuBar();

        Menu filem = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        newItem.addEventHandler(javafx.event.ActionEvent.ACTION, (javafx.event.ActionEvent e) -> {
            ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).setText("");
        });
        newItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+N"));
        MenuItem openItem = new MenuItem("Open");
        openItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+O"));
        openItem.addEventHandler(javafx.event.ActionEvent.ACTION, (javafx.event.ActionEvent e) -> {
            // creates a new instance of a file picker
            javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
            // sets the title of the file picker
            fileChooser.setTitle("Open Resource File");
            javafx.stage.FileChooser.ExtensionFilter extFilter = new javafx.stage.FileChooser.ExtensionFilter(
                    "TXT files (*.txt)", "*.txt"); // creates a filter so only .txt files can be selected
            // adds the filter to the file picket
            fileChooser.getExtensionFilters().add(extFilter);
            // shows the open dialog and stores the opened file to the "file" variable
            java.io.File file = fileChooser.showOpenDialog(stage);
            if (file != null) { // if the file was opened successfully
                // open file
                StringBuilder sb = new StringBuilder();
                try (java.util.Scanner scanner = new java.util.Scanner(file)) {
                    // create a scanner to read the file line by line
                    while (scanner.hasNextLine()) { // loop over each line
                        sb.append(scanner.nextLine()); // add the line to the StringBuilder
                        sb.append(System.lineSeparator()); // add a line separator
                    }
                } catch (FileNotFoundException e1) {
                    // if the file cannot be opened display a message
                    e1.printStackTrace();
                }
                // set the text from the StringBuilder to a TextArea
                ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).setText(sb.toString());
            }

        });

        MenuItem saveItem = new MenuItem(
                "Save");
        saveItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+S"));
        saveItem.addEventHandler(javafx.event.ActionEvent.ACTION, (javafx.event.ActionEvent e) -> {
            // creates a new instance of a file picker
            javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
            // sets the title of the file picker
            fileChooser.setTitle("Save Resource File");
            javafx.stage.FileChooser.ExtensionFilter extFilter = new javafx.stage.FileChooser.ExtensionFilter(
                    "TXT files (*.txt)", "*.txt"); // creates a filter so only .txt files can be selected
            // adds the filter to the file picket
            fileChooser.getExtensionFilters().add(extFilter);
            // shows the save dialog and stores the opened file to the "file" variable
            java.io.File file = fileChooser.showSaveDialog(stage);
            if (file != null) { // if the file was opened successfully
                // open file
                try (java.io.PrintWriter pw = new java.io.PrintWriter(file)) {
                    // create a PrintWriter to write to the file
                    pw.println(((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getText());
                } catch (FileNotFoundException e1) {
                    // if the file cannot be opened display a message
                    e1.printStackTrace();
                }
            }
        });
        MenuItem printItem = new MenuItem(
                "Print");
        printItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+P"));
        printItem.addEventHandler(javafx.event.ActionEvent.ACTION, (javafx.event.ActionEvent e) -> {
            javafx.print.PrinterJob job = javafx.print.PrinterJob.createPrinterJob();
            if (job != null) {
                boolean success = job.printPage(((TextArea) ((BorderPane) scene.getRoot()).getCenter()));
                if (success) {
                    job.endJob();
                }
            }
        });
        MenuItem exitItem = new MenuItem(
                "Exit");
        exitItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+E"));
        exitItem.addEventHandler(javafx.event.ActionEvent.ACTION, (javafx.event.ActionEvent e) -> {
            stage.close();
        });
        filem.getItems().addAll(newItem, openItem, saveItem, printItem, new SeparatorMenuItem(), exitItem);

        Menu edit = new Menu("Edit");
        MenuItem undoItem = new MenuItem(
                "Undo");
        undoItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+Z"));
        undoItem.addEventHandler(javafx.event.ActionEvent.ACTION, (javafx.event.ActionEvent e) -> {
            ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).undo();
        });
        MenuItem cutItem = new MenuItem(
                "Cut");
        cutItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+X"));
        cutItem.addEventHandler(javafx.event.ActionEvent.ACTION, (
                javafx.event.ActionEvent e) -> {
            javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
            javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
            content.putString(((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getSelectedText());
            clipboard.setContent(content);
            // Get the TextArea from the scene
            ((TextArea) ((BorderPane) scene.getRoot()).getCenter())
                    // Get the current text from the TextArea
                    .setText(((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getText()
                            // Replace the selected text with "" (i.e., delete the selected text)
                            .replace(((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getSelectedText(), ""));
        });
        MenuItem copyItem = new MenuItem(
                "Copy");
        copyItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+C"));
        copyItem.addEventHandler(javafx.event.ActionEvent.ACTION, (
                javafx.event.ActionEvent e) -> {
            javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
            javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
            content.putString(((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getSelectedText());
            clipboard.setContent(content);
        });
        MenuItem pasteItem = new MenuItem(
                "Paste");
        pasteItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+V"));
        pasteItem.addEventHandler(javafx.event.ActionEvent.ACTION, (
                javafx.event.ActionEvent e) -> {
            javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
            // append the clipboard text to the TextArea
            ((TextArea) ((BorderPane) scene.getRoot()).getCenter())
                    .setText(((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getText()
                            + clipboard.getString());
        });
        MenuItem deleteItem = new MenuItem(
                "Delete");
        deleteItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+D"));
        deleteItem.addEventHandler(javafx.event.ActionEvent.ACTION, (
                javafx.event.ActionEvent e) -> {
            // Get the TextArea from the scene
            ((TextArea) ((BorderPane) scene.getRoot()).getCenter())
                    // Get the current text from the TextArea
                    .setText(((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getText()
                            // Replace the selected text with "" (i.e., delete the selected text)
                            .replace(((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getSelectedText(), ""));
        });
        MenuItem selectAllItem = new MenuItem(
                "Select All");
        selectAllItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+A"));
        selectAllItem.addEventHandler(javafx.event.ActionEvent.ACTION, (
                javafx.event.ActionEvent e) -> {
            ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).selectAll();
        });
        MenuItem findItem = new MenuItem("Find");
        findItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+F"));
        findItem.addEventHandler(javafx.event.ActionEvent.ACTION, (javafx.event.ActionEvent e) -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Find");
            dialog.setHeaderText("Find");
            dialog.setContentText("Enter the text to find:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                String text = ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getText();
                int index = text.indexOf(result.get());
                if (index >= 0) {
                    ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).selectRange(index,
                            index + result.get().length());
                }
            }
        });
        MenuItem replaceItem = new MenuItem("Replace");
        replaceItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+R"));
        replaceItem.addEventHandler(javafx.event.ActionEvent.ACTION, (javafx.event.ActionEvent e) -> {
            // create a new TextInputDialog
            TextInputDialog replaceDialog = new TextInputDialog();
            replaceDialog.setTitle("Replace");
            replaceDialog.setHeaderText("Replace");
            replaceDialog.setContentText("Replace with:");

            // get the result from the dialog
            Optional<String> replaceResult = replaceDialog.showAndWait();

            // if the result is present (i.e. the user clicked OK), get the text the user
            // entered
            if (replaceResult.isPresent()) {
                String replaceText = replaceResult.get();
                String selectedText = ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getSelectedText();
                String currentText = ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).getText();

                // if no text is selected, show an alert dialog
                if (selectedText == null || selectedText.isEmpty()) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Replace");
                    alert.setHeaderText("No Text Selected");
                    alert.setContentText("Please select the text you want to replace.");
                    alert.showAndWait();
                } else {
                    // replace the selected text with the text the user entered
                    String newText = currentText.replace(selectedText, replaceText);
                    ((TextArea) ((BorderPane) scene.getRoot()).getCenter()).setText(newText);
                }
            }
        });

        edit.getItems().addAll(undoItem, cutItem, copyItem, pasteItem, deleteItem, new SeparatorMenuItem(),
                selectAllItem, new SeparatorMenuItem(), findItem, replaceItem);

        Menu help = new Menu("Help");
        MenuItem aboutItem = new MenuItem(
                "About Notepad");
        aboutItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("Ctrl+H"));
        aboutItem.addEventHandler(javafx.event.ActionEvent.ACTION, (
                javafx.event.ActionEvent e) -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("About Notepad");
            alert.setHeaderText("Notepad by soRouR!");
            alert.setContentText(
                    "Notepad is a simple text editor for the JavaFX platform.");
            alert.showAndWait();
        });
        help.getItems().add(aboutItem);

        bar.getMenus().addAll(filem, edit, help);

        TextArea textArea = new TextArea();
        BorderPane root = new BorderPane();
        root.setTop(bar);
        root.setCenter(textArea);
        scene = new Scene(root, 640, 480);
        stage.setTitle("Notepad");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}