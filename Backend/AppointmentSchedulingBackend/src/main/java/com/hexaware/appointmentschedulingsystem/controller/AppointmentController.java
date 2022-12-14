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

import com.hexaware.appointmentschedulingsystem.entity.Appointment;
import com.hexaware.appointmentschedulingsystem.service.AppointmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin("*")
@RestController
@RequestMapping("/appointment")
@Api(value = "appointment Management System",description = "Operations of appointments class")

public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/viewallappointment")
	@ApiOperation(value = "To view all appointments", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved all appointments"),
			@ApiResponse(code = 401,message = "You are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "Accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	List<Appointment> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}

	
	@PostMapping("/addappointment")
	@ApiOperation(value = "add an appointment")
	Appointment saveAppointment(
			@ApiParam (value = "appointment object is stored in database",required = true)
			@RequestBody Appointment appointment) {
		return appointmentService.saveAppointment(appointment);
		
	}
	
	@DeleteMapping("/deleteappointmentbyid/{id}")
	@ApiOperation(value = "deletes a Appointment")
	void deleteAppointment(
			@PathVariable("id") Long appointmentId) {
		appointmentService.deleteAppointmentById(appointmentId);
	}
	
	
	@GetMapping("/getappointmentbyid/{id}")
	@ApiOperation(value = "Get an appointment by id")
	Optional<Appointment> getAppointmentById(
			@ApiParam (value="returns the appointment with id",required = true)
			@PathVariable("id") Long appointmentId){
		return appointmentService.getAppointmentById(appointmentId);
	}

	
	@PutMapping("/updateappointmentbyid/{id}")
	@ApiOperation(value = "update an appointment.......")
	Appointment updateAppointment(
			@ApiParam (value = "Appointment object to update",required = true)
			 @Valid @RequestBody Appointment appointment,
			@ApiParam (value="returns the appointment with id to update",required = true)
			@PathVariable("id") Long appointmentId) throws Exception {
		Appointment existingAppointment =  appointmentService.getAppointmentById(appointmentId)
				.orElseThrow(() -> new Exception("Appointment not found with id" + appointmentId));
//		existingAppointment.setAppointmentId(appointment.getAppointmentId());
		existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
		existingAppointment.setAppointmentStatus(appointment.getAppointmentStatus());
		existingAppointment.setUserId(appointment.getUserId());
		existingAppointment.setDoctorId(appointment.getDoctorId());
		existingAppointment.setFee(appointment.getFee());
		
		return appointmentService.updateAppointment(existingAppointment);
	}
	
	@GetMapping("/getappointmentbyuserid/{userid}")
	@ApiOperation(value = "Get an appointment by userid")
	public Optional<List<Appointment>> findAppointmentByUserId(@ApiParam (value="returns the appointment with userid",required = true)
	@PathVariable("userid") Long userId) {
		return appointmentService.findAppointmentByUserId(userId);
		
	}
	
	/*@PatchMapping("/updateappointmentstatusbyappointmentid/{userid}/{appointmentid}")
	@ApiOperation(value = "update an appointment status by appointmentid.......")
	public List<Appointment> updateAppointmentStatusByUserId(
			@ApiParam (value = "Appointment status to update by appointmentid",required = true)
	 @RequestBody Appointment appointment,
	@ApiParam (value="returns the appointment with id to update",required = true)
	@PathVariable("appointmentid") Long appointmentId, 
	@PathVariable("userid") Long userId) throws Exception {
		Appointment existingAppointment = appointmentService.getAppointmentById(appointmentId)
				.orElseThrow(() -> new Exception("Appointment not found with appointmentid" + userId));
		existingAppointment.setAppointmentStatus(appointment.getAppointmentStatus());
		return appointmentService.updateAppointmentStatusByUserId(userId,appointmentId);
		
	}*/
//	@PutMapping("/updateappointment/{appid}")
//	public String updateAppointment(@RequestBody Appointment appointment, @PathVariable("appointmentid") Long appointmentId) {
//		return appointmentService.updateAppointment(appointment, appointmentId) + "Appointment updated successfully";
//	}


	@GetMapping("/getappointmentbydoctorid/{doctorid}")
	@ApiOperation(value = "Get an appointment by doctorid")
	public List<Appointment> findAppointmentByDoctorId(@ApiParam (value="returns the appointment with doctorid",required = true)
	@PathVariable("doctorid") Long doctorId) {
		return appointmentService.findAppointmentByDoctorId(doctorId);
		
	}
	
	/*@GetMapping("/getdoctorbyuserid/{userid}")
	@ApiOperation(value = "Get a doctor by userid")
	public List<Appointment> findDoctorByUserId(@ApiParam (value="returns the doctor with userid",required = true)
	@PathVariable("userid") Long userId) {
		return appointmentService.findDoctorByUserId(userId);
		
	}*/

}
