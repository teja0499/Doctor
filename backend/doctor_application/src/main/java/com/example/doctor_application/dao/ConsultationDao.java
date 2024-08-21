package com.example.doctor_application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.doctor_application.dto.Consultation;
import com.example.doctor_application.repository.ConsultationRepo;


@Repository
public class ConsultationDao {

	@Autowired
	private ConsultationRepo cRepo;
	
	public Consultation save(Consultation consultation)
	{
		return cRepo.save(consultation);
	}
	public List<Consultation> findByDid(long did)
	{
		List<Consultation>consultations=cRepo.findByDidAndViewTrue(did); 
		return consultations.reversed();
	}
	
	public List<Consultation> findByPid(long pid)
	{
		List<Consultation>consultations=cRepo.findByPid(pid); 
		return consultations.reversed();
	}
	
	public List<Consultation> findByDidAndDoctorViewFalse(long did)
	{
		List<Consultation>consultations=cRepo.findByDidAndViewFalse(did); 
		return consultations.reversed();
	}
	public Consultation update(Consultation consultation)
	{
		consultation.setView(true);
		return cRepo.save(consultation);
	}
	
	public List<Consultation> getAllConsultation()
	{
		List<Consultation>consultations=cRepo.findAll();
		return consultations.reversed();
	}
	
	public boolean existsByTransactionId(String Id)
	{
		return cRepo.existsByTransactionId(Id);
	} 
	
}