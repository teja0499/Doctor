package com.example.doctor_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_application.dto.Consultation;

public interface ConsultationRepo extends JpaRepository<Consultation,Long>{

	List<Consultation> findByDid(long did);
	
	List<Consultation> findByDidAndViewFalse(long did);
	
	List<Consultation> findByDidAndViewTrue(long did);
	
	List<Consultation> findByPid(long pid);
	
	boolean existsByTransactionId(String Id);

}
