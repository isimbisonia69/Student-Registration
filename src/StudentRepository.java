package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentRepository {

    public void saveStudent(Student student) {

        String sql = "INSERT INTO students(full_name, age, email) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            String fullName = student.getFirstName() + " " + student.getLastName();

            statement.setString(1, fullName);
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getEmail());

            statement.executeUpdate();

            System.out.println("Student saved successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}