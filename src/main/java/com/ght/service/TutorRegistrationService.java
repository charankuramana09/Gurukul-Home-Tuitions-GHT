package com.ght.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.PersonalDetails;
import com.ght.model.TutorDetails;
import com.ght.repository.PersonalDetailsRepository;
import com.ght.repository.TutorDetailsRepository;

@Service
public class TutorRegistrationService {

    @Autowired
    private TutorDetailsRepository tutorDetailsRepository;
    
    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

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
        return tutorDetailsRepository.findAll().stream()
            .filter(tutor -> {
                String expertInClass = tutor.getExpertInClass();
                if (expertInClass == null || expertInClass.isEmpty()) {
                    return false;
                }
                String[] subjects = expertInClass.toLowerCase().split(",");
                return List.of(subjects).contains(subject.toLowerCase().trim());
            })
            .collect(Collectors.toList());
    }

    public List<Object[]> getTutors() {
        List<TutorDetails> tutorDetailsList = tutorDetailsRepository.findAll();
        return tutorDetailsList.stream()
                .map(tutorDetails -> {
                    PersonalDetails personalDetails = personalDetailsRepository.findById(tutorDetails.getPersonalDetails().getId()).orElseThrow();
                    String base64Image = Base64.getEncoder().encodeToString(tutorDetails.getImage());
                    return new Object[]{personalDetails.getName(), personalDetails.getEmail(), tutorDetails.getExpertInClass(), base64Image};
                })
                .collect(Collectors.toList());
    }
    
    public boolean authenticate(String email, String password) {
        try {
            PersonalDetails personalDetails = personalDetailsRepository.findByEmail(email);
            return personalDetails != null && personalDetails.getPassword().equals(password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Optional<TutorDetails> getTutorByEmail(String email) {
        Optional<PersonalDetails> personalDetails = Optional.ofNullable(personalDetailsRepository.findByEmail(email));
        
        if (personalDetails.isPresent()) {
            return tutorDetailsRepository.findByPersonalDetails(personalDetails.get());
        }
        
        return Optional.empty();
    }
}
