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
            Student student = studentRegistrationRepository.findByEmail(email);
            return student != null && student.getPassword().equals(password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
