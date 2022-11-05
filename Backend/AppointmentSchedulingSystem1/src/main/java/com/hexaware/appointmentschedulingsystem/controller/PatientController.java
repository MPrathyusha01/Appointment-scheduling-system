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

import com.hexaware.appointmentschedulingsystem.entity.Patient;
import com.hexaware.appointmentschedulingsystem.service.PatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("/patient")
@Api(value = "Patient Management System",description = "Operations of Patient class")

public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	
	@GetMapping("/getallpatient")
	@ApiOperation(value = "To view all patients", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved all patients"),
			@ApiResponse(code = 401,message = "You are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "Accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	List<Patient> getAllPatients(){
		return patientService.findAll();
	}
	
//	@GetMapping("/getallpatients")
//	public List<Patient> getAllPatients() {
//		return patientService.findAll();
//	}
	
	
	@PostMapping("/addpatient")
	@ApiOperation(value = "add an patient")
	Patient savePatient(
			@ApiParam (value = "Patient object is stored in database",required = true)
			@RequestBody Patient patient) {
		return patientService.savePatient(patient);
		
	}
	
//	@PostMapping("/addpatient")
//	public String savePatient(@RequestBody Patient patient) {
//		return patientService.savePatient(patient) + "patient added Successfully";
//		
//	}
	@DeleteMapping("/deletepatientbyid/{id}")
	@ApiOperation(value = "deletes a patient")
	void deletePatient(
			@PathVariable("id") Long patient_id) {
		patientService.deletePatientById(patient_id);
	}
	
//	@DeleteMapping("/deletepatient/{userid}")
//	public void deletePatient(@PathVariable("userid") Long userId) {
//		patientService.deleteByIdPatient(userId);
//	}
	
	
	@GetMapping("/getpatientbyid/{id}")
	@ApiOperation(value = "Get an patient by id")
	Optional<Patient> findPatientById(
			@ApiParam (value="returns the patient with id",required = true)
			@PathVariable("id") Long patient_id){
		return patientService.findPatientById(patient_id);
	}
	
//	@GetMapping("/getpatient/{userid}")
//	public Patient getPatient(@PathVariable("userid") Long userId) {
//		return patientService.findByIdPatient(userId);
//	}
	
	
	@PutMapping("/updatepatientbyid/{id}")
	@ApiOperation(value = "update an patient.......")
	Patient updatePatient(
			@ApiParam (value = "Patient object to update",required = true)
			 @Valid @RequestBody Patient patient,
			@ApiParam (value="returns the patient with id to update",required = true)
			@PathVariable("id") Long userId) throws Exception {
		Patient existingPatient =  patientService.findPatientById(userId)
				.orElseThrow(() -> new Exception("Patient not found with id" + userId));
		existingPatient.setUserId(patient.getUserId());
		existingPatient.setUserName(patient.getUserName());
		existingPatient.setAddress(patient.getAddress());
		existingPatient.setPassword(patient.getPassword());
		existingPatient.setPatientName(patient.getPatientName());
		existingPatient.setPhoneNo(patient.getPhoneNo());
		existingPatient.setUserEmail(patient.getUserEmail());
		existingPatient.setDob(patient.getDob());
		existingPatient.setGender(patient.getGender());
		
		return patientService.updatePatientById(existingPatient, userId);
	}
	
//	@PutMapping("/products/{id}")
//	@ApiOperation(value = "update an product.......")
//	Product updateProduct(
//			@ApiParam (value = "Product object to update",required = true)
//			 @Valid @RequestBody Product product,
//			@ApiParam (value="returns the product with id to update",required = true)
//			@PathVariable("id") Long pId) throws Exception {
//		Product existingProduct =  productService.getProductById(pId)
//				.orElseThrow(() -> new Exception("Product not found with id" + pId));
//		existingProduct.setProductId(product.getProductId());
//		existingProduct.setProductName(product.getProductName());
//		existingProduct.setProductPrice(product.getProductPrice());
//		
//		return productService.updateProduct(existingProduct);
//	}
	
//	@PutMapping("/updatepatient/{patientid}")
//	public String updatePatient(@RequestBody Patient patient, @PathVariable("userid") Long userId) {
//		return patientService.updatePatient(patient, userId) + "Patient updated successfully";
//	}
	
	


}
