package com.hexaware.appointmentschedulingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.appointmentschedulingsystem.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

}
