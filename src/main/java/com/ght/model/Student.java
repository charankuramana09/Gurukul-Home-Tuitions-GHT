package com.ght.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal details
    private String name;
    private String surname;
    private String gender;
    private String dob;  
    private String city;
    private String mobileNo;
    @Column(unique = true)
    private String email;
    private String password;
    private String confirmPassword;

    // Educational details
    private String board;
    private String school;
    private String className;
    private String preferredTimings;  
    private Integer daysPerWeek;
    private Integer sessionDuration;
    private String addressLine1;
    private String addressLine2;

    // Parent details
    private String fatherName;
    private String fatherOccupation;
    private String fatherPhone;
    private String fatherEmail;
    private String motherName;
    private String motherOccupation;
    private String motherPhone;
    private String motherEmail;
    private String parentAddress;
    
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;
    
    
	public Student() {
		super();
	}


	public Student(Long id, String name, String surname, String gender, String dob, String city, String mobileNo,
			String email, String password, String confirmPassword, String board, String school, String className,
			String preferredTimings, Integer daysPerWeek, Integer sessionDuration, String addressLine1,
			String addressLine2, String fatherName, String fatherOccupation, String fatherPhone, String fatherEmail,
			String motherName, String motherOccupation, String motherPhone, String motherEmail, String parentAddress,
			byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.dob = dob;
		this.city = city;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.board = board;
		this.school = school;
		this.className = className;
		this.preferredTimings = preferredTimings;
		this.daysPerWeek = daysPerWeek;
		this.sessionDuration = sessionDuration;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.fatherName = fatherName;
		this.fatherOccupation = fatherOccupation;
		this.fatherPhone = fatherPhone;
		this.fatherEmail = fatherEmail;
		this.motherName = motherName;
		this.motherOccupation = motherOccupation;
		this.motherPhone = motherPhone;
		this.motherEmail = motherEmail;
		this.parentAddress = parentAddress;
		this.image = image;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getBoard() {
		return board;
	}


	public void setBoard(String board) {
		this.board = board;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getPreferredTimings() {
		return preferredTimings;
	}


	public void setPreferredTimings(String preferredTimings) {
		this.preferredTimings = preferredTimings;
	}


	public Integer getDaysPerWeek() {
		return daysPerWeek;
	}


	public void setDaysPerWeek(Integer daysPerWeek) {
		this.daysPerWeek = daysPerWeek;
	}


	public Integer getSessionDuration() {
		return sessionDuration;
	}


	public void setSessionDuration(Integer sessionDuration) {
		this.sessionDuration = sessionDuration;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getFatherOccupation() {
		return fatherOccupation;
	}


	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}


	public String getFatherPhone() {
		return fatherPhone;
	}


	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}


	public String getFatherEmail() {
		return fatherEmail;
	}


	public void setFatherEmail(String fatherEmail) {
		this.fatherEmail = fatherEmail;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getMotherOccupation() {
		return motherOccupation;
	}


	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}


	public String getMotherPhone() {
		return motherPhone;
	}


	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}


	public String getMotherEmail() {
		return motherEmail;
	}


	public void setMotherEmail(String motherEmail) {
		this.motherEmail = motherEmail;
	}


	public String getParentAddress() {
		return parentAddress;
	}


	public void setParentAddress(String parentAddress) {
		this.parentAddress = parentAddress;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}
  
    
    
    
    }
