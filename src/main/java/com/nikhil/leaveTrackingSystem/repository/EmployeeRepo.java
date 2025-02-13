package com.nikhil.leaveTrackingSystem.repository;

import com.nikhil.leaveTrackingSystem.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel,Integer> {

}
