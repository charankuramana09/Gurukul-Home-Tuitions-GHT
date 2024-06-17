package com.ght.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ght.model.Student;
import com.ght.repository.StudentRegistrationRepository;

import java.util.List;

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

    // Updated: Changed authenticate method to return a Student object instead of a boolean.
    public Student authenticate(String email, String password) {
        List<Student> students = studentRegistrationRepository.findByEmail(email);
        
        if (students.isEmpty()) {
            return null; // No student found
        }
        
        Student student = students.get(0); // Get the first student in the list
        if (student.getPassword().equals(password)) {
            return student; // Return student details if password matches.
        } else {
            return null; // Return null if authentication fails.
        }
    }
}
