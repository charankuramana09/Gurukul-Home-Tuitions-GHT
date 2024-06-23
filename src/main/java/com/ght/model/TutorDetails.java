package com.ght.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class TutorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String surname;
    private String gender;
    private String dob;
    private String city;
    @Column(unique = true)
    private String mobileNo;
    @Column(unique = true)
    private String email;
    private String password;

   
    @Lob
    @Column(name = "resume", columnDefinition = "LONGBLOB")
    private byte[] resume;

    @Lob
    @Column(name = "drivingLicense", columnDefinition = "LONGBLOB")
    private byte[] drivingLicense;

    @Lob
    @Column(name = "addressProof", columnDefinition = "LONGBLOB")
    private byte[] addressProof;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;
 
    @Column(name = "expertInClass", nullable = false)
    private String expertInClass;  
}
