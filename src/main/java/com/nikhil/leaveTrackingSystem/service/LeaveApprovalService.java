package com.nikhil.leaveTrackingSystem.service;

import com.nikhil.leaveTrackingSystem.model.ApproveLeaveModel;
import com.nikhil.leaveTrackingSystem.model.LeaveModel;
import com.nikhil.leaveTrackingSystem.model.LeaveTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface LeaveApprovalService {
    public List<LeaveModel> getPendingLeaves();

    Boolean approveLeaveById(LeaveModel request);

    public List<?> getOverview(String type);


}
