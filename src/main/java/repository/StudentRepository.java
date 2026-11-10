package repository;

import model.Student;
import config.DatabaseConfig;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public void saveStudent(Student student) {

        String sql = "INSERT INTO students (full_name, age, email) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            String fullName = student.getFirstName() + " " + student.getLastName();

            statement.setString(1, fullName);
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getEmail());

            statement.executeUpdate();

            System.out.println("Student saved successfully!");

        } catch (SQLException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                String fullName = resultSet.getString("full_name");
                String[] names = fullName.split(" ", 2);

                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setFirstName(names[0]);
                student.setLastName(names[1]);
                student.setAge(resultSet.getInt("age"));
                student.setEmail(resultSet.getString("email"));

                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }

        return students;
    }
}