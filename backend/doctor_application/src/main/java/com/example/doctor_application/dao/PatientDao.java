package com.example.doctor_application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.doctor_application.dto.Patient;
import com.example.doctor_application.repository.PatientRepo;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class PatientDao {

	@Autowired
	private PatientRepo pRepo;
	
	public Patient signUp(Patient patient)
	{
		if(pRepo.findByMobileNumber(patient.getMobileNumber())!=null)
		{
			throw new DuplicateKeyException("Mobile Number Already exist");
		}
		else if(pRepo.findByEmail(patient.getEmail())!=null)
		{
			throw new DuplicateKeyException("Email Already exist");
		}
		return pRepo.save(patient);
	}
	
	public Patient login(String email,String password)
	{
		System.out.println(email);
		Patient patient=pRepo.findByEmailAndPassword(email,password);
		if(patient==null)
		{
			throw new EntityNotFoundException("Credential missmatch");
		}
		return patient;
	}
	
	public List<Patient> getAllUser()
	{
		return pRepo.findAll();
	}
	
}
