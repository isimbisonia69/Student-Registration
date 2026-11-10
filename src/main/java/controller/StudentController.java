package controller;

import model.Student;
import service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute("student", new Student());

        return "register";
    }

    @PostMapping("/student/register")
    public String registerStudent(
            @ModelAttribute("student") Student student,
            RedirectAttributes redirectAttributes) {

        studentService.registerStudent(student);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Student registered successfully!"
        );

        return "redirect:/student/all";
    }

    @GetMapping("/student/all")
    public String showAllStudents(Model model) {

        List<Student> students = studentService.getAllStudents();

        model.addAttribute("students", students);

        return "students";
    }
}