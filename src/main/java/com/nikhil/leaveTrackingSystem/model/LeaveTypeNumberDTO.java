package com.nikhil.leaveTrackingSystem.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class LeaveTypeNumberDTO {

    @DateTimeFormat(pattern = "ddMMyyyy")
    private Date leaveDate;

    private Long count;

    public LeaveTypeNumberDTO(Date leaveDate, Long count) {
        this.leaveDate = leaveDate;
        this.count = count;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
