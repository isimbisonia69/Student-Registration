

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {

        String url = "jdbc:postgresql://localhost:5432/student_management";
        String username = "postgres";
        String password = "your_password";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully!");

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }

        return connection;
    }
}