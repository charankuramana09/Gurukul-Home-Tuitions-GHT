package com.ght.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ght.model.TutorDetails;
import com.ght.service.TutorRegistrationService;

@RestController
@RequestMapping("/api/tutors")
@CrossOrigin(origins = "*")
public class TutorRegistrationController {

    @Autowired
    private TutorRegistrationService tutorRegistrationService;

    private final Path rootLocation = Paths.get("uploads");

    public TutorRegistrationController() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage location", e);
        }
    }

    private byte[] storeFile(MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            if (filename == null || filename.contains("..")) {
                throw new RuntimeException("Invalid file path");
            }
            return file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerTutor(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("gender") String gender,
            @RequestParam("dob") String dob,
            @RequestParam("city") String city,
            @RequestParam("mobileNo") String mobileNo,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam(value = "subjects") String[] subjects,
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("drivingLicense") MultipartFile drivingLicense,
            @RequestParam("addressProof") MultipartFile addressProof,
            @RequestParam("photo") MultipartFile photo
    ) {
        try {
            TutorDetails tutorDetails = new TutorDetails();
            tutorDetails.setName(name);
            tutorDetails.setSurname(surname);
            tutorDetails.setGender(gender);
            tutorDetails.setDob(dob);
            tutorDetails.setCity(city);
            tutorDetails.setMobileNo(mobileNo);
            tutorDetails.setEmail(email);
            tutorDetails.setPassword(password);
            tutorDetails.setResume(storeFile(resume));
            tutorDetails.setDrivingLicense(storeFile(drivingLicense));
            tutorDetails.setAddressProof(storeFile(addressProof));
            if (!photo.isEmpty()) {
                tutorDetails.setImage(storeFile(photo));
            }
            String subjectsJoined = String.join(",", subjects);
            tutorDetails.setExpertInClass(subjectsJoined);

            TutorDetails registeredTutor = tutorRegistrationService.registerTutor(tutorDetails);
            return new ResponseEntity<>(registeredTutor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register tutor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TutorDetails>> getEntityById(@PathVariable Long id) {
        Optional<TutorDetails> tutorDetails = tutorRegistrationService.findById(id);
        if (tutorDetails.isPresent()) {
            return new ResponseEntity<>(tutorDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TutorDetails>> getAllTutors() {
        List<TutorDetails> tutors = tutorRegistrationService.getAllTutors();
        if (tutors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    @GetMapping("/fields")
    public ResponseEntity<List<Object[]>> getTutors() {
        List<Object[]> tutors = tutorRegistrationService.getTutors();
        if (tutors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody TutorDetails tutorDetails) {
        Optional<TutorDetails> authenticatedTutor = tutorRegistrationService.authenticate(tutorDetails.getEmail(), tutorDetails.getPassword());
        
        if (authenticatedTutor.isPresent()) {
            return ResponseEntity.ok(authenticatedTutor.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @GetMapping("/by-email")
    public ResponseEntity<?> getTutorByEmails(@RequestParam("email") String email) {
        Optional<TutorDetails> tutorDetails = tutorRegistrationService.getTutorByEmail(email);
        if (tutorDetails.isPresent()) {
            return new ResponseEntity<>(tutorDetails.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tutor not found for email: " + email, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-subject")
    public ResponseEntity<List<TutorDetails>> getTutorsBySubject(@RequestParam String subject) {
        List<TutorDetails> tutors = tutorRegistrationService.getTutorsBySubject(subject);
        if (tutors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Object[]>> getTutorByEmail(@PathVariable String email) {
        List<Object[]> tutors = tutorRegistrationService.getTutorByEmailDashboard(email);
        if (!tutors.isEmpty()) {
            return new ResponseEntity<>(tutors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
