package com.nikhil.leaveTrackingSystem.model;

import jakarta.persistence.Column;

public class ApproveLeaveModel {

    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String comment;
}
