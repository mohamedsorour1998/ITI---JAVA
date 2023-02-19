package com.example;

import java.util.ArrayList;

import javafx.scene.control.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    /**
     * @param args
     * @throws Exception
     */
    int index = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        // add the main label
        Label lblMain = new Label("Address Book");
        root.add(lblMain, 1, 0);
        // add 3 labels for name, email, and cell phone
        Label lblName = new Label("Name");
        Label lblEmail = new Label("Email");
        Label lblCellPhone = new Label("Cell Phone");
        root.add(lblName, 0, 5);
        root.add(lblEmail, 0, 4);
        root.add(lblCellPhone, 0, 3);
        // getting the data from the database
        dataBaseApp db = new dataBaseApp();
        ArrayList<ContactPerson> contacts = db.getContacts();
        // add 3 text fields for , email, and cell phone
        TextField txtName = new TextField();
        txtName.setText("A name will appear here From the database");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("An Email will appear here From the database");
        TextField txtCellPhone = new TextField();
        txtCellPhone.setPromptText("A Cell Phone will appear here From the database");
        root.add(txtName, 1, 5);
        root.add(txtEmail, 1, 4);
        root.add(txtCellPhone, 1, 3);
        // add 4 buttons First, Previous, Next, Last to root pane
        Button btnFirst = new Button("First");
        btnFirst.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (javafx.scene.input.MouseEvent e) -> {
            index = 0;
            txtName.setText(contacts.get(index).getName());
            txtEmail.setText(contacts.get(index).getEmail());
            txtCellPhone.setText(contacts.get(index).getCellphone());
        });
        Button btnPrevious = new Button("Previous");
        btnPrevious.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (javafx.scene.input.MouseEvent e) -> {
            if (index > 0) {
                index--;
                txtName.setText(contacts.get(index).getName());
                txtEmail.setText(contacts.get(index).getEmail());
                txtCellPhone.setText(contacts.get(index).getCellphone());
            } else if (index <= 0) {
                txtName.setText("You have reached the beginning of the DB!");
                txtEmail.setText("You have reached the beginning of the DB!");
                txtCellPhone.setText("You have reached the beginning of the DB!");
                index = 0;
            } else if (index == 0) {
                txtName.setText(contacts.get(index).getName());
                txtEmail.setText(contacts.get(index).getEmail());
                txtCellPhone.setText(contacts.get(index).getCellphone());
            }
        });
        Button btnNext = new Button("Next");
        btnNext.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (javafx.scene.input.MouseEvent e) -> {
            if (index < contacts.size()) {
                index++;
                txtName.setText(contacts.get(index).getName());
                txtEmail.setText(contacts.get(index).getEmail());
                txtCellPhone.setText(contacts.get(index).getCellphone());
            } else if (index >= contacts.size()) {
                txtName.setText("You have reached the end of the DB!");
                txtEmail.setText("You have reached the end of the DB!");
                txtCellPhone.setText("You have reached the end of the DB!");
                index = contacts.size() - 1;
            } else if (index == contacts.size() - 1) {
                txtName.setText(contacts.get(index).getName());
                txtEmail.setText(contacts.get(index).getEmail());
                txtCellPhone.setText(contacts.get(index).getCellphone());
            }

        });
        Button btnLast = new Button("Last");
        btnLast.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (javafx.scene.input.MouseEvent e) -> {
            index = contacts.size() - 1;
            txtName.setText(contacts.get(index).getName());
            txtEmail.setText(contacts.get(index).getEmail());
            txtCellPhone.setText(contacts.get(index).getCellphone());

        });
        Button btnInfo = new Button("Info");
        btnInfo.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (javafx.scene.input.MouseEvent e) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About the App");
            alert.setHeaderText("Developed by: soRouR!");
            alert.setContentText(
                    "Look, This is an Address Book App! that uses JDBC to connect and retrieve data from mySql database!");
            alert.showAndWait();
        });
        // make them appear at the bottom
        root.add(btnNext, 2, 6);
        root.add(btnPrevious, 1, 6);
        root.add(btnFirst, 0, 6);
        root.add(btnLast, 3, 6);
        root.add(btnInfo, 4, 6);
        // Setting the vertical and horizontal gaps between the columns
        root.setVgap(30);
        root.setHgap(10);
        // Setting the root alignment to be centered and the buttons to be at the bottom
        root.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Address Book App");
        // set title and show stage
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}