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
    public String applyLeave(int id,LeaveModel leave) {
        System.out.println("saving in repo");
        try{
        Optional<EmployeeModel>employee=employeeRepo.findById(id);
        if(employee.isPresent()){
            EmployeeModel e = employee.get();
            if(e.getRemaining_leaves()<=0){
                return "you are out of leaves";
            }
            leave.setEmployee(e);
            leaveRepo.save(leave);
            return "leave applied successfully";
        }
        }catch (Exception e){
            return e.getMessage();

        }
        return " employee details not found";
    }

    @Override
    public List<Optional<LeaveModel>> getLeaveById(int empId) {
            return leaveRepo.findLeavesById(empId);
    }
}
