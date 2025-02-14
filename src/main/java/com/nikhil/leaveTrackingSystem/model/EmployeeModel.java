package com.nikhil.leaveTrackingSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class EmployeeModel {

    @Id
    @Column(nullable = false)
    private int employee_id;

    @Column(nullable = false)
    private String employee_name;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<LeaveModel>leaves;

    private int availed_leaves=0;


    private int remaining_leaves=2;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getAvailed_leaves() {
        return availed_leaves;
    }

    public void setAvailed_leaves(int availed_leaves) {
        this.availed_leaves = availed_leaves;
    }

    public int getRemaining_leaves() {
        return remaining_leaves;
    }

    public void setRemaining_leaves(int remaining_leaves) {
        this.remaining_leaves = remaining_leaves;
    }

    public List<LeaveModel> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<LeaveModel> leaves) {
        this.leaves = leaves;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", availed_leaves=" + availed_leaves +
                ", remaining_leaves=" + remaining_leaves +
                '}';
    }
}
