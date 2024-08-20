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
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor_application.dao.ConsultationDao;
import com.example.doctor_application.dto.Consultation;

@RestController
public class ConsultationController {
	
	@Autowired
	private ConsultationDao cDao;
	
	@PostMapping("/save-consultation")
	public ResponseEntity<?> saveConsultation(@RequestBody  Consultation newconsultation)
	{
		System.out.println("working");
		try {
			Consultation consultation=cDao.save(newconsultation);
			return ResponseEntity.ok(consultation);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@GetMapping("/doctor/consultation_history/{did}")
	public ResponseEntity<?> getConsultationHistory(@PathVariable ("did") long did)
	{
		System.out.println("working");
		try {
			List<Consultation> consultations=cDao.findByDid(did);
			return ResponseEntity.ok(consultations);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@GetMapping("/doctor/consultation_req/{did}")
	public ResponseEntity<?> getConsultationReq(@PathVariable ("did") long did)
	{
		System.out.println("working");
		try {
			List<Consultation> consultations=cDao.findByDidAndDoctorViewFalse(did);
			return ResponseEntity.ok(consultations);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@PutMapping("/update-consultation")
	public ResponseEntity<?> saveUpdateConsultation(@RequestBody  Consultation newconsultation)
	{
		System.out.println("working");
		try {
			System.out.println(newconsultation);
			Consultation consultation=cDao.update(newconsultation);
			return ResponseEntity.ok(consultation);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@GetMapping("/get-consultation/{pid}")
	public ResponseEntity<?> getConsultations(@PathVariable ("pid") long pid)
	{
		System.out.println("working");
		try {
			List<Consultation> consultations=cDao.findByPid(pid);
			return ResponseEntity.ok(consultations);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@GetMapping("/admin/get_all_prescription")
	public ResponseEntity<?> getAllConsultation()
	{
		System.out.println("working");
		try {
			List<Consultation> consultations=cDao.getAllConsultation();
			return ResponseEntity.ok(consultations);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
}
