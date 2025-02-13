package com.nikhil.leaveTrackingSystem.model;

import org.springframework.format.annotation.DateTimeFormat;

public class LeaveTypeDTO {

    private String type;
    private Long count; // Change to Long to match the result type
//    private DateTimeFormat date;

    // Constructor to match the query result
    public LeaveTypeDTO(String type, Long count) {
        this.type = type;
        this.count = count;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
