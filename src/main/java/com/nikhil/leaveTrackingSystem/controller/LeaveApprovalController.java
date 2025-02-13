package com.nikhil.leaveTrackingSystem.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nikhil.leaveTrackingSystem.model.LeaveModel;
import com.nikhil.leaveTrackingSystem.model.ApproveLeaveModel;
import com.nikhil.leaveTrackingSystem.model.LeaveTypeDTO;
import com.nikhil.leaveTrackingSystem.service.LeaveApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Component
@RestController
@RequestMapping("/manager")
public class LeaveApprovalController {

    @Autowired
    LeaveApprovalService leaveApprovalService;

    @GetMapping("pending-leaves")
    public List<LeaveModel> getPendingLeaves() {
        return leaveApprovalService.getPendingLeaves();
    }


    @PostMapping("approve-leave")
    public ResponseEntity<String> approveLeaveById( @RequestBody LeaveModel request) {
        System.out.println(request.toString());
        boolean approvalSuccess = leaveApprovalService.approveLeaveById(request);

        if (approvalSuccess) {
            return ResponseEntity.ok("Leave approved successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Failed to approve leave. Please check the leave ID and details.");
        }
    }

    @GetMapping("overview/{type}")
    public List<?> getOverview(@PathVariable String type){
        return leaveApprovalService.getOverview(type);
    }
}
