package com.example.doctor_application.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor_application.dao.PatientDao;
import com.example.doctor_application.dto.Patient;

@RestController
public class PatientController {

	@Autowired
	private PatientDao pDao;
	
	
	@PostMapping("/patient/sign_up")
	public ResponseEntity<?> signUp(@RequestBody Patient newpatient)
	{
		try {
		 Patient patient=	pDao.signUp(newpatient);
		 return ResponseEntity.status(200).body(patient);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@PostMapping("/patient/login")
	public ResponseEntity<?> login(@RequestHeader("email") String email,@RequestHeader("password") String password)
	{
		System.out.println("working");
		try {
			Patient patient=pDao.login(email, password);
			return ResponseEntity.status(200).body(patient);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@GetMapping("/admin/get_users")
	public ResponseEntity<?> getUsers()
	{
		System.out.println("working");
		try {
			List<Patient> patient=pDao.getAllUser();
			return ResponseEntity.status(200).body(patient);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
}
