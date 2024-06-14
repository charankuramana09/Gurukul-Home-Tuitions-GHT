package com.ght.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.Student;
import com.ght.service.StudentRegistrationService;

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
    public Student createStudent(@RequestBody Student student) {
        return studentRegistrationService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentRegistrationService.getStudentById(id);
        if (student != null) {

            // Update personal details
            student.setName(studentDetails.getName());
            student.setSurname(studentDetails.getSurname());
            student.setGender(studentDetails.getGender());
            student.setDob(studentDetails.getDob());
            student.setCity(studentDetails.getCity());
            student.setMobileNo(studentDetails.getMobileNo());
            student.setEmail(studentDetails.getEmail());
            student.setPassword(studentDetails.getPassword());
            student.setConfirmPassword(studentDetails.getConfirmPassword());

            // Update additional details
            student.setBoard(studentDetails.getBoard());
            student.setSchool(studentDetails.getSchool());
            student.setClassName(studentDetails.getClassName());
            student.setPreferredTimings(studentDetails.getPreferredTimings());
            student.setDaysPerWeek(studentDetails.getDaysPerWeek());
            student.setSessionDuration(studentDetails.getSessionDuration());
            student.setAddressLine1(studentDetails.getAddressLine1());
            student.setAddressLine2(studentDetails.getAddressLine2());
            student.setFatherName(studentDetails.getFatherName());
            student.setFatherOccupation(studentDetails.getFatherOccupation());
            student.setFatherPhone(studentDetails.getFatherPhone());
            student.setFatherEmail(studentDetails.getFatherEmail());
            student.setMotherName(studentDetails.getMotherName());
            student.setMotherOccupation(studentDetails.getMotherOccupation());
            student.setMotherPhone(studentDetails.getMotherPhone());
            student.setMotherEmail(studentDetails.getMotherEmail());
            student.setParentAddress(studentDetails.getParentAddress());

            // Update photo
            student.setPhoto(studentDetails.getPhoto());

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
    public String login(@RequestBody Student loginStudent) {
        boolean isAuthenticated = studentRegistrationService.authenticate(loginStudent.getEmail(), loginStudent.getPassword());
        if (isAuthenticated) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }
}
