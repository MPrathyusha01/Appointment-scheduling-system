package com.hexaware.appointmentschedulingsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Patient")

public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "patient_name")
	private String patientName;
	@Column(name = "address")
	private String address;
	@Column(name = "password")
	private String password;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "dob")
	private String dob;
	@Column(name = "gender")
	private String gender;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="user_id_fk",referencedColumnName = "user_id")
	private List<Appointment> appointmentList = new ArrayList<>();
	
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(Long userId, String userName, String patientName, String address, String password, String userEmail,
			String phoneNo, String dob, String gender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.patientName = patientName;
		this.address = address;
		this.password = password;
		this.userEmail = userEmail;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.gender = gender;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
