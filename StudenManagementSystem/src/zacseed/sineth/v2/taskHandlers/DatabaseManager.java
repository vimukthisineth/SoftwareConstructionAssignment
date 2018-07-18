package zacseed.sineth.v2.taskHandlers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {

    private Connection connection = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmdb","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
