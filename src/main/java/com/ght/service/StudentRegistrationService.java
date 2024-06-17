package com.ght.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ght.model.Student;
import com.ght.repository.StudentRegistrationRepository;

@Service
public class StudentRegistrationService {

    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    public List<Student> getAllStudents() {
        return studentRegistrationRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRegistrationRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRegistrationRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRegistrationRepository.deleteById(id);
    }

    public boolean authenticate(String email, String password) {
        try {
            List<Student> students = studentRegistrationRepository.findByEmail(email);
            
            if (students.isEmpty()) {
                return false; // No student found
            }
            
            // Optionally, log or handle the case where multiple students have the same email
            if (students.size() > 1) {
                System.err.println("Multiple students found with email: " + email);
                // Handle as needed, e.g., log an error, choose the first, etc.
            }

            Student student = students.get(0); // Get the first student in the list
            return student.getPassword().equals(password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
