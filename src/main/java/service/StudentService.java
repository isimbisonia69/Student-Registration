package service;

import model.Student;
import repository.StudentRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}