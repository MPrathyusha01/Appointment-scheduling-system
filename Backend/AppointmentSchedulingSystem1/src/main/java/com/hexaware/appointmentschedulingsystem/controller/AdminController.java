package com.hexaware.appointmentschedulingsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.appointmentschedulingsystem.entity.Admin;
import com.hexaware.appointmentschedulingsystem.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("/adminapi")
@Api(value = "Admin Management System",description = "Operations of Admin class")

public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/getalladmins")
	@ApiOperation(value = "To view all admins", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved all admins"),
			@ApiResponse(code = 401,message = "You are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "Accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	List<Admin> getAllAdmins() {
		return adminService.findAllAdmin();
	}
	
	@PostMapping("/addadmin")
	@ApiOperation(value = "To add an admin")
	Admin saveAdmin(
			@ApiParam (value = "Admin object is stored in database",required = true)
			@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
		
	}
	
	@DeleteMapping("/deleteadminbyadmin/{adminid}")
	@ApiOperation(value = "To deletes a admin")
	void deleteAdmin(@PathVariable("adminid") Long adminId) {
		adminService.deleteAdminById(adminId);
	}
	
	@GetMapping("/getadminbyid/{adminid}")
	@ApiOperation(value = "Get the admin by id")
	Optional<Admin> getAdmin(@PathVariable("adminid") Long adminId) {
		return adminService.findAdminById(adminId);
	}

	@PutMapping("/updateadminbyid/{id}")
	@ApiOperation(value = "To update an admin")
	Admin updateAdmin(
			@ApiParam (value = "Admin object to update",required = true)
			 @Valid @RequestBody Admin admin,
			@ApiParam (value="returns the admin with id to update",required = true)
			@PathVariable("id") Long adminId) throws Exception {
		Admin existingAdmin =  adminService.findAdminById(adminId)
				.orElseThrow(() -> new Exception("Admin not found with id" + adminId));
		existingAdmin.setAdminId(admin.getAdminId());
		existingAdmin.setAdminName(admin.getAdminName());
		
		
		return adminService.updateAdmin(existingAdmin);
	}

}

















