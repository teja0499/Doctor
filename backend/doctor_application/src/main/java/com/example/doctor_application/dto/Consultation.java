package com.example.doctor_application.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "patient_name")
    private String patientName;
    
    private Long did;
    
    private Long pid;

    @Column(name = "current_illness")
    private String currentIllness;

    @Column(name = "recent_surgery")
    private String recentSurgery;

   
    private String diabetics;

   
    private String allergies;

  
    private String others;
    
    private String medicine;
    @Column(name = "care_to_be_taken")
    private String careToBeTaken;
    private String date;
    private boolean view;
    
    private String doctorName;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getDid() {
		return did;
	}


	public void setDid(Long did) {
		this.did = did;
	}


	public Long getPid() {
		return pid;
	}


	public void setPid(Long pid) {
		this.pid = pid;
	}


	public String getCurrentIllness() {
		return currentIllness;
	}


	public void setCurrentIllness(String currentIllness) {
		this.currentIllness = currentIllness;
	}


	public String getRecentSurgery() {
		return recentSurgery;
	}


	public void setRecentSurgery(String recentSurgery) {
		this.recentSurgery = recentSurgery;
	}


	public String getDiabetics() {
		return diabetics;
	}


	public void setDiabetics(String diabetics) {
		this.diabetics = diabetics;
	}


	public String getAllergies() {
		return allergies;
	}


	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}


	public String getOthers() {
		return others;
	}


	public void setOthers(String others) {
		this.others = others;
	}


	public boolean isView() {
		return view;
	}


	public void setView(boolean view) {
		this.view = view;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getMedicine() {
		return medicine;
	}


	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}


	public String getCareToBeTaken() {
		return careToBeTaken;
	}


	public void setCareToBeTaken(String careToBeTaken) {
		this.careToBeTaken = careToBeTaken;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	@Override
	public String toString() {
		return "Consultation [id=" + id + ", patientName=" + patientName + ", did=" + did + ", pid=" + pid
				+ ", currentIllness=" + currentIllness + ", recentSurgery=" + recentSurgery + ", diabetics=" + diabetics
				+ ", allergies=" + allergies + ", others=" + others + ", medicine=" + medicine + ", careToBeTaken="
				+ careToBeTaken + ", date=" + date + ", view=" + view + ", doctorName=" + doctorName + "]";
	}
	
	
	
	

    
  
}
