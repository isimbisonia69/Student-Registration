package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    public static Connection getConnection() {

        String url = "jdbc:postgresql://localhost:5432/student_management";
        String username = "postgres";
        String password = "mukankusi";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully!");

            return connection;

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            return null;
        }
    }
}
