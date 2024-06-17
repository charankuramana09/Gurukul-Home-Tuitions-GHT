package com.ght.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ght.model.Student;
import com.ght.service.StudentRegistrationService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/students")
public class StudentRegistrationController {

    @Autowired
    private StudentRegistrationService studentRegistrationService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRegistrationService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentRegistrationService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Student> createStudent(
            @RequestParam("image") MultipartFile image,
            @RequestPart("student") Student student) {
        try {
            if (image != null && !image.isEmpty()) {
                student.setImage(image.getBytes());
            }
            Student savedStudent = studentRegistrationService.saveStudent(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null); // Updated: Improved error handling.
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentRegistrationService.getStudentById(id);
        if (student != null) {
            // Update details
            // ... Set student details similar to your initial code
            final Student updatedStudent = studentRegistrationService.saveStudent(student);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentRegistrationService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    // Updated: Changed login endpoint to return Student details upon successful login.
    public ResponseEntity<Student> login(@RequestBody Student loginStudent) {
        Student authenticatedStudent = studentRegistrationService.authenticate(loginStudent.getEmail(), loginStudent.getPassword());
        if (authenticatedStudent != null) {
            return ResponseEntity.ok(authenticatedStudent); // Return Student details if authentication is successful.
        } else {
            return ResponseEntity.status(401).body(null); // Return 401 status if authentication fails.
        }
    }
}
