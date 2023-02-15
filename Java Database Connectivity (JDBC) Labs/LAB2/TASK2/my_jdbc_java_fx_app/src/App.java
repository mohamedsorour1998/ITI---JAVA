import java.util.ArrayList;
import java.util.Date;
import javafx.application.Application;
import java.sql.*;

public class App extends Application {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        dataBaseApp db = new dataBaseApp();

        /// uncomment the following to retrieve all contacts from the database
        // ArrayList<ContactPerson> contacts = db.getContacts();
        // contacts.forEach((ContactPerson) ->
        /// System.out.println(ContactPerson.getName()));
        // contacts.forEach((ContactPerson) ->
        /// System.out.println(ContactPerson.getAddress()));
        // contacts.forEach((ContactPerson) ->
        /// System.out.println(ContactPerson.getCellphone()));
        // contacts.forEach((ContactPerson) ->
        /// System.out.println(ContactPerson.getBirthday()));
        launch();

    }
}