package com.hexaware.appointmentschedulingsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.appointmentschedulingsystem.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	public Optional<List<Appointment>> findAppointmentByUserId(Long userId);
	public List<Appointment> findAppointmentByDoctorId(Long doctorId);
	//public List<Appointment> updateAppointmentStatusByUserId(Long userId, Long appointmentId);
}
