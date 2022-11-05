package com.hexaware.appointmentschedulingsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.appointmentschedulingsystem.entity.Appointment;

public interface AppointmentService {
	
//	public List<Appointment> findAll();
//	public Optional<Appointment> findByIdAppointment(Long appointmentId);
	public void deleteAppointmentById(Long appointmentId);
	public Appointment saveAppointment(Appointment appointment);
	public Appointment updateAppointment(Appointment appointment);
	public List<Appointment> getAllAppointments();
	public Optional<Appointment> getAppointmentById(Long appointmentId);
	public Optional<List<Appointment>> findAppointmentByUserId(Long userId);
	//public List<Appointment> updateAppointmentStatusByUserId(Long userId, Long appointmentId) throws Exception;
	public List<Appointment> findAppointmentByDoctorId(Long doctorId);
	//public List<Appointment> findDoctorByUserId(Long userId);
	
}
