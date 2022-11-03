package com.hexaware.appointmentschedulingsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.appointmentschedulingsystem.entity.Patient;
import com.hexaware.appointmentschedulingsystem.exception.ResourceNotFoundException;

public interface PatientService {
	
	public List<Patient> findAll();
	public Optional<Patient> findPatientById(Long userId);
//	public Patient findPatientById(Long userId);
	public void deletePatientById(Long userId);
	public Patient savePatient(Patient patient);
//	public Patient updatePatient(Patient patient, Long userId);
	public Patient updatePatientById(Patient existingPatient, Long patient_id) throws ResourceNotFoundException;
	//public List<Doctor> findDoctorByUserId(Long userId);

}
