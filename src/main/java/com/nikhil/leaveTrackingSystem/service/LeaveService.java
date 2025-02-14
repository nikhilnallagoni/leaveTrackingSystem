package com.nikhil.leaveTrackingSystem.service;

import com.nikhil.leaveTrackingSystem.model.LeaveModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LeaveService {
    String applyLeave(int id,LeaveModel leave);

    List<Optional<LeaveModel>> getLeaveById(int id);

}
