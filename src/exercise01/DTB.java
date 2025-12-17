package exercise01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DTB {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/session14exercise01?createIfNotExist", "root", "123456");
            if (con != null) {
                System.out.println("Connected to the database");
            } else {
                System.out.println("Failed to make connection");
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }return null;
    }
}
