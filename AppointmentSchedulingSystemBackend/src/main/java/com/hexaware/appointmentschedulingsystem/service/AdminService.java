package com.hexaware.appointmentschedulingsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.appointmentschedulingsystem.entity.Admin;

public interface AdminService {
	
	public List<Admin> findAllAdmin();
	public Optional<Admin> findAdminById(Long adminId);
	public void deleteAdminById(Long adminId);
	public Admin saveAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
//	public Admin getAdminById(Long adminId);
	

}
