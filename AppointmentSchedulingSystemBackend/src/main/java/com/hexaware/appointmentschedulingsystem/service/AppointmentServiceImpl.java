package com.hexaware.appointmentschedulingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.appointmentschedulingsystem.entity.Appointment;
import com.hexaware.appointmentschedulingsystem.repository.AppointmentRepository;
@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepository appointmentRepo;

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepo.findAll();
	}

	@Override
	public Optional<Appointment> getAppointmentById(Long userId) {
		
		return appointmentRepo.findById(userId);
	}

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		
		return appointmentRepo.save(appointment);
	}

	@Override
	public void deleteAppointmentById(Long appointment_id) {
		
		appointmentRepo.deleteById(appointment_id);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		
		return appointmentRepo.save(appointment);
	}

	@Override
	public Optional<List<Appointment>> findAppointmentByUserId(Long userId) {
		
		return appointmentRepo.findAppointmentByUserId(userId);
	}

	@Override
	public List<Appointment> findAppointmentByDoctorId(Long doctorId) {
		
		return appointmentRepo.findAppointmentByDoctorId(doctorId);
	}

	

	/*@Override
	public List<Appointment> findDoctorByUserId(Long userId) {
		
		return appointmentRepo.findDoctorByUserId(userId);
	}*/

	/*@Override
	public List<Appointment> updateAppointmentStatusByUserId(Long userId,Long appointmentId) {
		
		return appointmentRepo.updateAppointmentStatusByUserId(userId, appointmentId);
	}*/

	
	

	

}
