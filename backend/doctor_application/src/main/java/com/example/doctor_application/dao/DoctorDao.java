package com.example.doctor_application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.doctor_application.dto.Doctor;
import com.example.doctor_application.repository.DoctorRepo;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class DoctorDao {

	@Autowired
	private DoctorRepo drepo;
	
	public Doctor signUp(Doctor doctor)
	{
		if(drepo.findByMobileNumber(doctor.getMobileNumber())!=null)
		{
			throw new DuplicateKeyException("Mobile Number Already exist");
		}
		else if(drepo.findByEmail(doctor.getEmail())!=null)
		{
			throw new DuplicateKeyException("Email Already exist");
		}
		return drepo.save(doctor);
	}
	
	public Doctor login(String email,String password)
	{
		Doctor doctor=drepo.findByEmailAndPassword(email, password);
		
		if(doctor==null)
		{
			throw new EntityNotFoundException("Credential missmatch");
		}
//		System.out.println(drepo.findByEmail(email));
		return doctor;
	}
	
	public List<Doctor> getAllDoctor()
	{
		List<Doctor> doctors=drepo.findByAdminApproveTrue();
//		List<Doctor>doctors=drepo.findAll();
		for(int i=0;i<doctors.size();i++)
		{
			doctors.get(i).setPassword(null);
		}
		
		
		return doctors;
	}
	
	public List<Doctor> getNewDoctor()
	{
		List<Doctor> doctors=drepo.findByAdminViewFalse();
//		List<Doctor>doctors=drepo.findAll();
		for(int i=0;i<doctors.size();i++)
		{
			doctors.get(i).setPassword(null);
		}
		
		
		return doctors;
	}
	
	public Doctor update(Doctor newdoctor)
	{
		Doctor doctor=drepo.findByDid(newdoctor.getDid());
		doctor.setAdminView(true);
		doctor.setAdminApprove(newdoctor.isAdminApprove());
		System.out.println(doctor);
		return drepo.save(doctor);
	}
	
}
