package com.hexaware.appointmentschedulingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.appointmentschedulingsystem.entity.Admin;
import com.hexaware.appointmentschedulingsystem.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public List<Admin> findAllAdmin() {
		
		return adminRepo.findAll();
	}

	@Override
	public Optional<Admin> findAdminById(Long adminId) {
		
		return adminRepo.findById(adminId);
	}

	@Override
	public void deleteAdminById(Long adminId) {
		adminRepo.deleteById(adminId);
		
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}


//	@Override
//	public Object getAdminById(Long adminId) {
//		// TODO Auto-generated method stub
//		return adminRepo.findById(adminId);
//	}
	

}
