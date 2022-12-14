package com.hexaware.appointmentschedulingsystem.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Appointment")
public class Appointment {
		
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "appointment_id")
	private Long appointmentId;
	@Column(name = "appointment_date")
	private LocalDateTime appointmentDate;
	@Column(name = "appointment_status")
	private String appointmentStatus;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "doctor_id")
	private Long doctorId;
	@Column(name = "fee")
	private int fee;
	
	
	public Appointment() {
		// TODO Auto-generated constructor stub
	}


	public Long getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}


	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public String getAppointmentStatus() {
		return appointmentStatus;
	}


	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}


	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}


	public Appointment(Long appointmentId, LocalDateTime appointmentDate, String appointmentStatus, Long userId,
			Long doctorId, int fee) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
		this.userId = userId;
		this.doctorId = doctorId;
		this.fee = fee;
	}


	
	

}
