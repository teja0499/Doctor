package com.example.doctor_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_application.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin,Long>{
	Admin findByEmailAndPassword(String email,String password);
}
