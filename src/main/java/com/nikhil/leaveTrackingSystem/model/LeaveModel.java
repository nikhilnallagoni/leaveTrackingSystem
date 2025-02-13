package com.nikhil.leaveTrackingSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.boot.registry.selector.StrategyRegistration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

@Table(name = "leaves")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore

    private EmployeeModel employee;

    @JsonProperty("emp_id")
    public int getEmpId(){
        return employee.getEmployee_id();
    }
    public EmployeeModel getEmployee() {
        return employee;
    }


    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }



    @Column(name="leave_type",nullable = false)
    private String leaveType;


    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name="start_date",nullable = false)
    private LocalDate startDate;


    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name="end_date",nullable = false)
    private LocalDate endDate;

    @Column(name="status")
    private Boolean status = false;

    @Column(name = "comment")
    private String comment = "Pending";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LeaveModel{" +
                "id=" + id +
                ", leaveType='" + leaveType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                '}';
    }
}
