
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
            Connection conn = dataSource.loadDataSource().getConnection();
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

    public void setContacts(ContactPerson cp) {
        try {
            // connect to database
            Connection conn = dataSource.loadDataSource().getConnection();
            System.out.println("Connection established!");
            // create an insert statement
            String sql = "INSERT INTO contacts (name, nickname, adress, home_phone, work_phone, cell_phone, email, web_site, birthday, profission) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cp.getName());
            stmt.setString(2, cp.getNickname());
            stmt.setString(3, cp.getAddress());
            stmt.setString(4, cp.getHomephone());
            stmt.setString(5, cp.getWorkphone());
            stmt.setString(6, cp.getCellphone());
            stmt.setString(7, cp.getEmail());
            stmt.setString(8, cp.getWebStie());
            stmt.setDate(9, cp.getBirthday());
            stmt.setString(10, cp.getProfession());
            // execute the insert statement
            stmt.executeUpdate();
            if (stmt.executeUpdate() > 0) {
                // print out a message if the insert was successful
                System.out.println("A new contact was inserted successfully!");
                stmt.close();
            }
            // close connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    public ArrayList<ContactPerson> getContactsForName(String Name) {
        try {
            // connect to database
            Connection conn = dataSource.loadDataSource().getConnection();
            System.out.println("Connection established!");
            // create statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts where name like '%" + Name + "%' ORDER BY name");

            // processing result
            ArrayList<ContactPerson> ContactsForName = new ArrayList<>();
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
                ContactsForName.add(cp);
            }
            if (ContactsForName.isEmpty()) {
                System.out.println("No contact found!");
            }
            // close connection
            conn.close();
            return ContactsForName;

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
    }

    public void deleteContactsForName(String Name) {
        try {
            // connect to database
            Connection conn = dataSource.loadDataSource().getConnection();
            System.out.println("Connection established!");
            // create statement
            Statement stmt = conn.createStatement();
            // execute the delete statement
            String sql = "DELETE FROM contacts WHERE name = '" + Name + "'";
            stmt.executeUpdate(sql);
            // print out a message if the delete was successful or not
            if (stmt.executeUpdate(sql) > 0) {
                System.out.println("A contact was deleted successfully!");
            } else {
                System.out.println("No contact was deleted!");
            }
            stmt.close();
            // close connection
            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    public void updateContacts(ContactPerson cp) {
        try {
            // connect to database
            Connection conn = dataSource.loadDataSource().getConnection();
            System.out.println("Connection established!");
            // create an update statement
            String sql = "UPDATE contacts SET name = ?, nickname = ?, adress = ?, home_phone = ?, work_phone = ?, cell_phone = ?, email = ?, web_site = ?, birthday = ?, profission = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cp.getName());
            stmt.setString(2, cp.getNickname());
            stmt.setString(3, cp.getAddress());
            stmt.setString(4, cp.getHomephone());
            stmt.setString(5, cp.getWorkphone());
            stmt.setString(6, cp.getCellphone());
            stmt.setString(7, cp.getEmail());
            stmt.setString(8, cp.getWebStie());
            stmt.setDate(9, cp.getBirthday());
            stmt.setString(10, cp.getProfession());
            stmt.setInt(11, cp.getId());

            // execute the insert statement
            stmt.executeUpdate();
            if (stmt.executeUpdate() > 0) {
                // print out a message if the insert was successful
                System.out.println("A new contact was inserted successfully!");
                stmt.close();
            }
            // close connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }
}