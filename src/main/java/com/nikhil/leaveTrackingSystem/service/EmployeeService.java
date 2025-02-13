package com.nikhil.leaveTrackingSystem.service;

import com.nikhil.leaveTrackingSystem.model.EmployeeModel;
import com.nikhil.leaveTrackingSystem.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;


    public void addEmployee(EmployeeModel employee) {
        employeeRepo.save(employee);
    }
}
