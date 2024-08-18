package com.example.doctor_application.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Doctor {
	
	     @Id
	     @GeneratedValue(strategy = GenerationType.AUTO)
	    private long did;

	    @Column(name = "profile_picture")
	    private String profilePicture;
	    
	    private String name;

	    private String specialty;

	    @Column( unique = true)
	    private String email;

	    @Column(name = "mobile_number", nullable = false, unique = true)
	    private String mobileNumber;

	    @Column(name = "years_of_experience")
	    private double yearsOfExperience;
	    
	    private String Address;
	    
//	    @JsonIgnore
	    private String password;
	    
	    private boolean adminApprove;
	    
	    private boolean adminView;
	    
	    
	    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "doctors")
	    private List<Patient>patients;

		public long getDid() {
			return did;
		}

		public void setDid(long did) {
			this.did = did;
		}

		public String getProfilePicture() {
			return profilePicture;
		}

		public void setProfilePicture(String profilePicture) {
			this.profilePicture = profilePicture;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSpecialty() {
			return specialty;
		}

		public void setSpecialty(String specialty) {
			this.specialty = specialty;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public double getYearsOfExperience() {
			return yearsOfExperience;
		}

		public void setYearsOfExperience(double yearsOfExperience) {
			this.yearsOfExperience = yearsOfExperience;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<Patient> getPatients() {
			return patients;
		}

		public void setPatients(List<Patient> patients) {
			this.patients = patients;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public boolean isAdminApprove() {
			return adminApprove;
		}

		public void setAdminApprove(boolean adminApprove) {
			this.adminApprove = adminApprove;
		}

		public boolean isAdminView() {
			return adminView;
		}

		public void setAdminView(boolean adminView) {
			this.adminView = adminView;
		}
		
		
	    
		
	    
	    
		

}
