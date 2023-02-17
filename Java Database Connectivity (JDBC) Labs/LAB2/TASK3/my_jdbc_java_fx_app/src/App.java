import java.util.ArrayList;
import java.util.Date;
import javafx.*;
import javafx.application.Application;
import java.sql.*;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        dataBaseApp db = new dataBaseApp();

        /// uncomment the following to add a new contact from the database
        // ContactPerson cp = new ContactPerson();
        // cp.setName("Sorour");
        // cp.setAddress("Tehran");
        // cp.setCellphone("0789");
        // cp.setBirthday(new java.sql.Date(1998, 11, 19));
        // cp.setEmail("good@gmail.com");
        // cp.setHomephone("45678");
        // cp.setWorkphone("12345");
        // cp.setNickname("Sorour");
        // cp.setProfession("Student");
        // cp.setWebStie("www.google.com");
        // db.setContacts(cp);

        /// uncomment the following to retrieve a new contact from the database by name
        // ArrayList<ContactPerson> getContactsForNameArray =
        /// db.getContactsForName("Bruce Wayne");
        // getContactsForNameArray.forEach((ContactPersonForName) ->
        /// System.out.println(ContactPersonForName.getName()));
        // getContactsForNameArray
        // .forEach((ContactPersonForName) ->
        /// System.out.println(ContactPersonForName.getAddress()));
        // getContactsForNameArray
        // .forEach((ContactPersonForName) ->
        /// System.out.println(ContactPersonForName.getCellphone()));
        // getContactsForNameArray
        // .forEach((ContactPersonForName) ->
        /// System.out.println(ContactPersonForName.getBirthday()));
        // getContactsForNameArray.forEach((ContactPersonForName) ->
        /// System.out.println(ContactPersonForName.getEmail()));
        // getContactsForNameArray
        // .forEach((ContactPersonForName) ->
        /// System.out.println(ContactPersonForName.getHomephone()));
        // getContactsForNameArray
        // .forEach((ContactPersonForName) ->
        /// System.out.println(ContactPersonForName.getWorkphone()));

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

        /// uncomment the following to delete a contact from the database
        // db.deleteContactsForName("sorour");

        /// uncomment the following to update a contact from the database
        // ContactPerson cp = new ContactPerson();
        // cp.setName("Sorour");
        // cp.setAddress("Tehran");
        // cp.setCellphone("0789");
        // cp.setBirthday(new java.sql.Date(1998, 11, 19));
        // cp.setEmail("good@gmail.com");
        // cp.setHomephone("45678");
        // cp.setWorkphone("12345");
        // cp.setNickname("Sorour");
        // cp.setProfession("Student");
        // cp.setWebStie("www.google.com");
        // db.updateContacts(cp);

        /// uncomment the following to update a contact from the database using batch
        db.updateContactsBatch();
    }
}