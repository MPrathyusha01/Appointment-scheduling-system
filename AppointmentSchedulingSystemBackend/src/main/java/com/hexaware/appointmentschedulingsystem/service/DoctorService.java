package com.hexaware.appointmentschedulingsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.appointmentschedulingsystem.entity.Doctor;

public interface DoctorService {
	
	public List<Doctor> findAll();
	public Optional<Doctor> findDoctorById(Long doctorId);
//	public Doctor findDoctorById(Long doctorId);
	public void deleteDoctorById(Long doctorId);
	public Doctor saveDoctor(Doctor doctor);
	public Doctor updateDoctor(Doctor doctor);
	public List<Doctor> findDoctorBySpecialization(String specialization);

}
