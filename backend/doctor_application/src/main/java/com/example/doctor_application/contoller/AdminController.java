package com.example.doctor_application.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.doctor_application.dao.AdminDao;
import com.example.doctor_application.dto.Admin;
import jakarta.persistence.EntityNotFoundException;

@RestController
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	
	@PostMapping("/admin/login")
	public ResponseEntity<?> login(@RequestHeader("email") String email,@RequestHeader("password") String password)
	{
		
		System.out.println(email+""+password);
		try {
			Admin admin=adminDao.login(email, password);
			return ResponseEntity.ok(admin);
		}  catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@PostMapping("/admin/sign_up")
	public ResponseEntity<?> signUp(@RequestBody Admin newAdmin)
	{
//		System.out.println();
		try {
			Admin savedAdmin = adminDao.signUp(newAdmin);
	         return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
		} 
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	
}
