package com.hexaware.appointmentschedulingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long loginId;
	
	private Long id;
	private String password;
	private String role;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(Long loginId, Long id, String password, String role) {
		super();
		this.loginId = loginId;
		this.id = id;
		this.password = password;
		this.role = role;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
