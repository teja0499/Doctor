package com.example.doctor_application.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.doctor_application.dao.DoctorDao;
//import com.example.doctor_application.dao.Helper;
import com.example.doctor_application.dto.Doctor;
import com.example.doctor_application.dto.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorDao doctorDao;
	
//	@Autowired
//	private Helper helper;
	
	 private final ObjectMapper objectMapper = new ObjectMapper();
	
	@GetMapping("/")
	public String test()
	{
		System.out.println("Working");
//		return ResponseEntity.ok(200);
		return "hello Tejas";
	}
	
	@PostMapping("/doctor/sign_up")
	public ResponseEntity<?> signUp( @RequestParam("file") MultipartFile file,@RequestParam("data") String jsonData)
	{
//		System.out.println(newdoctor);
		try {
			
			 Doctor newdoctor = objectMapper.readValue(jsonData, Doctor.class);
//			 String path=helper.uploadFile(file,"d"+newdoctor.getMobileNumber());
//			 newdoctor.setProfilePicture(path);
//			
//			System.out.println(path);
			 Doctor savedDoctor = doctorDao.signUp(newdoctor);
	         return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
		} 
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@PostMapping("/doctor/login")
	public ResponseEntity<?> login(@RequestHeader("email") String email,@RequestHeader("password") String password)
	{
		
		System.out.println(email+""+password);
		try {
			Doctor doctor=doctorDao.login(email, password);
			return ResponseEntity.ok(doctor);
		}  catch (EntityNotFoundException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	@GetMapping("/get_all_doctor")
	public ResponseEntity<?> getAllDoctor()
	{
		try {
			List<Doctor> doctors=doctorDao.getAllDoctor();
			return ResponseEntity.ok(doctors);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@GetMapping("/admin/get_new_doctor")
	public ResponseEntity<?> getNewDoctor()
	{
		System.out.println("hi");
		try {
			List<Doctor> doctors=doctorDao.getNewDoctor();
			return ResponseEntity.ok(doctors);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@PutMapping("/admin/approved_doctor")
	public ResponseEntity<?> getAprovedDoctor(@RequestBody Doctor doctor)
	{
		System.out.println("hi2");
		try {
			Doctor doctors=doctorDao.update(doctor);
			return ResponseEntity.ok(doctors);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
}
