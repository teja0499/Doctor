package com.example.doctor_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_application.dto.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long>{
	
	 Doctor findByMobileNumber(String mobileNumber);
	 Doctor findByEmail(String email);
	 Doctor findByEmailAndPassword(String email,String password);
	 List<Doctor> findByAdminViewFalse();
	 List<Doctor> findByAdminApproveTrue();
	 Doctor findByDid(long did);
	 
}
