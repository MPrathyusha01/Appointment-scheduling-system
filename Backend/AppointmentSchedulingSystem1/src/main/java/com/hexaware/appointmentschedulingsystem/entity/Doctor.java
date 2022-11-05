package com.hexaware.appointmentschedulingsystem.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "doctor_id")
	private Long doctorId;
	@Column(name = "doctor_name")
	private String doctorName;
	@Column(name = "specialization")
	private String specialization;
	@Column(name = "consultant")
	private String consultant;
	@Column(name = "fee")
	private Long fee;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="doctor_id_fk",referencedColumnName = "doctor_id")
	private List<Appointment> appointmentList = new ArrayList<>();
	
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(Long doctorId, String doctorName, String specialization, String consultant, Long fee) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.consultant = consultant;
		this.fee = fee;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getConsultant() {
		return consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}

	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	
	
	

}
