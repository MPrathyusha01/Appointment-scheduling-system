package com.hexaware.appointmentschedulingsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.appointmentschedulingsystem.entity.Doctor;

import com.hexaware.appointmentschedulingsystem.service.DoctorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin("*")
@RestController
@RequestMapping("/doctor")
@Api(value = "Doctor Management System",description = "Operations of Doctor class")

public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/getalldoctors")
	@ApiOperation(value = "To view all doctors", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved all doctors"),
			@ApiResponse(code = 401,message = "You are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "Accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	List<Doctor> getAllDoctors(){
		return doctorService.findAll();
	}
	
//	@GetMapping("/getalldoctors")
//	public List<Doctor> getAllDoctors() {
//		return doctorService.findAll();
//	}
	
	
	@PostMapping("/adddoctor")
	@ApiOperation(value = "add an doctor")
	Doctor saveDoctor(
			@ApiParam (value = "Doctor object is stored in database",required = true)
			@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
		
	}
	
//	@PostMapping("/adddoctor")
//	public String saveDoctor(@RequestBody Doctor doctor) {
//		return doctorService.saveDoctor(doctor) + "Doctor added Successfully";
//		
//	}
	
	
	@DeleteMapping("/deletedoctor/{id}")
	@ApiOperation(value = "deletes a doctor")
	void deleteDoctor(
			@PathVariable("id") Long doctor_id) {
		doctorService.deleteDoctorById(doctor_id);
	}
	
//	@DeleteMapping("/deletedoctor/{doctorid}")
//	public void deleteDoctor(@PathVariable("doctorid") Long doctorId) {
//		doctorService.deleteByIdDoctor(doctorId);
//	}
	
	
	@GetMapping("/getdoctorbyid/{id}")
	@ApiOperation(value = "Get an doctor by id")
	Optional<Doctor> getDoctorById(
			@ApiParam (value="returns the doctor with id",required = true)
			@PathVariable("id") Long doctor_id){
		return doctorService.findDoctorById(doctor_id);
	}
	
//	@GetMapping("/getdoctor/{doctorid}")
//	public Doctor getDoctor(@PathVariable("doctorid") Long doctorId) {
//		return doctorService.findByIdDoctor(doctorId);
//	}
	
	
	@PutMapping("/updatedoctorbyid/{id}")
	@ApiOperation(value = "update an doctor.......")
	Doctor updateDoctor(
			@ApiParam (value = "Doctor object to update",required = true)
			 @Valid @RequestBody Doctor doctor,
			@ApiParam (value="returns the doctor with id to update",required = true)
			@PathVariable("id") Long doctorId) throws Exception {
		Doctor existingDoctor =  (doctorService.findDoctorById(doctorId))
				.orElseThrow(() -> new Exception("Doctor not found with id" + doctorId));
		existingDoctor.setDoctorId(doctor.getDoctorId());
		existingDoctor.setDoctorName(doctor.getDoctorName());
		existingDoctor.setSpecialization(doctor.getSpecialization());
		existingDoctor.setConsultant(doctor.getConsultant());
		existingDoctor.setFee(doctor.getFee());
		
		return doctorService.updateDoctor(existingDoctor);
	}
	
//	@PutMapping("/updatedoctor/{doctorid}")
//	public String updateDoctor(@RequestBody Doctor doctor, @PathVariable("doctorid") Long doctorId) {
//		return doctorService.updateDoctor(doctor, doctorId) + "Doctor updated successfully";
//	}

	@GetMapping("/getdoctorsbyspecialization")
	@ApiOperation(value = "To view doctors by specialization", response = List.class)
	public List<Doctor> findDoctorBySpecialization(String specialization) {
		return doctorService.findDoctorBySpecialization(specialization);
	}


}
