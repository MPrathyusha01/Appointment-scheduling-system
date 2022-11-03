package com.hexaware.appointmentschedulingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long adminId;
	
	private String adminName;
	private String Password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(Long adminId, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		Password = password;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
