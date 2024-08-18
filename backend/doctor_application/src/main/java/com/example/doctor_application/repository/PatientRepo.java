package com.example.doctor_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_application.dto.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long>{
	Patient findByMobileNumber(String mobileNumber);
	Patient findByEmail(String email);
	 Patient findByEmailAndPassword(String email, String password);
}
