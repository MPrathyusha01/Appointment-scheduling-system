package com.hexaware.appointmentschedulingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.appointmentschedulingsystem.entity.Patient;
import com.hexaware.appointmentschedulingsystem.exception.ResourceNotFoundException;
import com.hexaware.appointmentschedulingsystem.repository.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepository patientRepo;

	@Override
	public List<Patient> findAll() {
		
		return patientRepo.findAll();
	}

	@Override
	public Optional<Patient> findPatientById(Long userId) {
		
		return patientRepo.findById(userId);
	}

	@Override
	public void deletePatientById(Long userId) {
		patientRepo.deleteById(userId);
		
	}

	@Override
	public Patient savePatient(Patient patient) {
		
		return patientRepo.save(patient);
	}
//
//	@Override
//	public Patient updatePatient(Patient patient, Long userId) {
//		
//		return patientRepo.update
//	}
	
	@Override
	public Patient updatePatientById(Patient patient, Long userId) throws ResourceNotFoundException {
		Patient oldPatientdetails = findPatientById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient"));
//						-> new ResourceNotFound("Patient with id" + userId + " not found"));
		oldPatientdetails.setPatientName(patient.getPatientName());
		return patientRepo.save(oldPatientdetails);
	}

}
