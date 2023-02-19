package com.example;

/**
 * dataBaseApp
 */
import java.sql.*;
import java.util.ArrayList;

public class dataBaseApp {

    public dataBaseApp() {

        // load sql driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
    }

    public ArrayList<ContactPerson> getContacts() {
        try {
            // connect to database
            String url = "jdbc:mysql://localhost:3306/addressbook";
            String username = "root";
            String password = "sorour";
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");
            // create statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts ORDER BY name");
            // processing result
            ArrayList<ContactPerson> contacts = new ArrayList<>();
            while (rs.next()) {
                ContactPerson cp = new ContactPerson();
                cp.setId(rs.getInt("id"));
                cp.setName(rs.getString("name"));
                cp.setNickname(rs.getString("nickname"));
                cp.setAddress(rs.getString("adress"));
                cp.setHomephone(rs.getString("home_phone"));
                cp.setWorkphone(rs.getString("work_phone"));
                cp.setCellphone(rs.getString("cell_phone"));
                cp.setEmail(rs.getString("email"));
                cp.setWebStie(rs.getString("web_site"));
                cp.setBirthday(rs.getDate("birthday"));
                cp.setProfession(rs.getString("profission"));
                contacts.add(cp);
            }
            if (contacts.isEmpty()) {
                System.out.println("No contacts found!");
            }
            // close connection
            conn.close();
            return contacts;

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
    }
}