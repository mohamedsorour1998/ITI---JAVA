import java.io.FileInputStream;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class dataSource {

    public static MysqlDataSource loadDataSource() {
        // adding properties file and data source
        Properties prop = new Properties();
        MysqlDataSource dataSource = new MysqlDataSource();
        try {
            prop.load(new FileInputStream("src/DB.properties"));
            dataSource.setUrl(prop.getProperty("url"));
            dataSource.setUser(prop.getProperty("user"));
            dataSource.setPassword(prop.getProperty("password"));

            return dataSource;
        } catch (Exception e) {
            System.out.println("Error loading properties file!");
            e.printStackTrace();
            return null;
        }
    }
}
