package com.ght.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.TutorDetails;
import com.ght.repository.TutorDetailsRepository;

@Service
public class TutorRegistrationService {

    @Autowired
    private TutorDetailsRepository tutorDetailsRepository;

    public TutorDetails registerTutor(TutorDetails tutorDetails) {
        return tutorDetailsRepository.save(tutorDetails);
    }

    public Optional<TutorDetails> findById(Long id) {
        return tutorDetailsRepository.findById(id);
    }

    public List<TutorDetails> getAllTutors() {
        return tutorDetailsRepository.findAll();
    }

    public List<TutorDetails> getTutorsBySubject(String subject) {
        return tutorDetailsRepository.findTutorsBySubject(subject.toLowerCase());
    }

    public List<Object[]> getTutors() {
        List<TutorDetails> tutorDetailsList = tutorDetailsRepository.findAll();
        return tutorDetailsList.stream()
                .map(tutorDetails -> {
                    String base64Image = Base64.getEncoder().encodeToString(tutorDetails.getImage());
                    return new Object[]{tutorDetails.getName(), tutorDetails.getEmail(), tutorDetails.getExpertInClass(), base64Image};
                })
                .collect(Collectors.toList());
    }

    public Optional<TutorDetails> authenticate(String email, String password) {
        try {
            Optional<TutorDetails> tutorDetailsOptional = tutorDetailsRepository.findByEmail(email);
            if (tutorDetailsOptional.isPresent()) {
                TutorDetails tutorDetails = tutorDetailsOptional.get();
                if (tutorDetails.getPassword().equals(password)) {
                    return tutorDetailsOptional; // Return tutorDetails if authentication successful
                }
            }
            return Optional.empty(); // Return empty optional if authentication fails
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); // Return empty optional on exception
        }
    }

    public Optional<TutorDetails> getTutorByEmail(String email) {
        return tutorDetailsRepository.findByEmail(email);
    }

    public List<Object[]> getTutorByEmailDashboard(String email) {
        return tutorDetailsRepository.findByPersonalDetailsDashboard(email);
    }
}
