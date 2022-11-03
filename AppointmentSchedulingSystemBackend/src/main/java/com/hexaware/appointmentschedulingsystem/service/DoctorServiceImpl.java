package com.hexaware.appointmentschedulingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.appointmentschedulingsystem.entity.Doctor;
import com.hexaware.appointmentschedulingsystem.repository.DoctorRepository;
@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorRepository doctorRepo;

	@Override
	public List<Doctor> findAll() {
		
		return doctorRepo.findAll();
	}

	@Override
	public Optional<Doctor> findDoctorById(Long doctorId) {
		
		return doctorRepo.findById(doctorId);
	}

	@Override
	public void deleteDoctorById(Long doctorId) {
		doctorRepo.deleteById(doctorId);
		
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		
		return doctorRepo.save(doctor);
	}

	@Override
	public List<Doctor> findDoctorBySpecialization(String specialization) {
		
		return doctorRepo.findDoctorBySpecialization(specialization);
	}

}
