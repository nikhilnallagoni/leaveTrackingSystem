package com.nikhil.leaveTrackingSystem.service.Implementation;

import com.nikhil.leaveTrackingSystem.model.EmployeeModel;
import com.nikhil.leaveTrackingSystem.model.LeaveModel;
import com.nikhil.leaveTrackingSystem.repository.EmployeeRepo;
import com.nikhil.leaveTrackingSystem.repository.LeaveRepo;
import com.nikhil.leaveTrackingSystem.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImplementation implements LeaveService {

    @Autowired
    private LeaveRepo leaveRepo;

    @Autowired
    EmployeeRepo employeeRepo;
    public Boolean applyLeave(int id,LeaveModel leave) {
        System.out.println("saving in repo");
        try{
        Optional<EmployeeModel>employee=employeeRepo.findById(id);
        if(employee.isPresent()){
            EmployeeModel e = employee.get();
            leave.setEmployee(e);
            leaveRepo.save(leave);
            return true;

        }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return false;
    }

    @Override
    public List<Optional<LeaveModel>> getLeaveById(int empId) {
            return leaveRepo.findLeavesById(empId);
    }
}
