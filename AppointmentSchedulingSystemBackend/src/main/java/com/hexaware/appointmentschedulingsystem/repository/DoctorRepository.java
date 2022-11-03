package com.hexaware.appointmentschedulingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.appointmentschedulingsystem.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	public List<Doctor> findDoctorBySpecialization(String specialization);
}
