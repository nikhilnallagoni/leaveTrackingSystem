package com.nikhil.leaveTrackingSystem.service.Implementation;

import com.nikhil.leaveTrackingSystem.model.EmployeeModel;
import com.nikhil.leaveTrackingSystem.model.LeaveModel;
import com.nikhil.leaveTrackingSystem.model.LeaveTypeDTO;
import com.nikhil.leaveTrackingSystem.model.LeaveTypeNumberDTO;
import com.nikhil.leaveTrackingSystem.repository.EmployeeRepo;
import com.nikhil.leaveTrackingSystem.repository.LeaveRepo;
import com.nikhil.leaveTrackingSystem.service.LeaveApprovalService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class LeaveApprovalServiceImplementation implements LeaveApprovalService {
    @Autowired
    LeaveRepo leaveRepo;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    EmployeeRepo employeeRepo;

    public List<LeaveModel> getPendingLeaves() {
        return leaveRepo.findPendingLeaves();
    }

    @Override
    public Boolean approveLeaveById(LeaveModel request) {

        try {
            Optional<LeaveModel> leaveCheck = leaveRepo.findById(request.getId());
            System.out.println(leaveCheck.toString());
            Optional<EmployeeModel> employee = employeeRepo.findById(leaveCheck.get().getEmpId());
            System.out.println(employee.toString());
            if (leaveCheck.isPresent()) {
                if (employee.isPresent() && request.getStatus()) {

                    EmployeeModel e = employee.get();
                    int availed_leaves = e.getAvailed_leaves();
                    int remaining_leaves = e.getRemaining_leaves();
                    if (remaining_leaves == 0) {
                        return false;
                    }
                    availed_leaves += 1;
                    remaining_leaves -= 1;
                    e.setAvailed_leaves(availed_leaves);
                    e.setRemaining_leaves(remaining_leaves);
                }
                LeaveModel leave = leaveCheck.get();
                leave.setComment(request.getComment());
                leave.setStatus(request.getStatus());
                leaveRepo.save(leave);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List getOverview(String type) {
        try {
            if (type.equals("leave_type") || type.equals("comment")) {
                String queryStr = "SELECT " + type + ", COUNT(*) FROM leaves GROUP BY " + type;
                Query query = entityManager.createNativeQuery(queryStr, LeaveTypeDTO.class);

                return query.getResultList();
            } else {
                String queryStr = "SELECT " + type + ", COUNT(*) FROM leaves GROUP BY " + type;
                Query query = entityManager.createNativeQuery(queryStr, LeaveTypeNumberDTO.class);

                return query.getResultList();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<String>(Collections.singletonList(e.getMessage()));

        }
    }

}