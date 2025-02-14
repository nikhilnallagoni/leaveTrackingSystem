package com.nikhil.leaveTrackingSystem.controller;

import com.nikhil.leaveTrackingSystem.model.EmployeeModel;
import com.nikhil.leaveTrackingSystem.model.LeaveModel;
import com.nikhil.leaveTrackingSystem.service.EmployeeService;
import com.nikhil.leaveTrackingSystem.service.LeaveService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("applyLeave/{id}")
    public ResponseEntity<String> applyLeave(@PathVariable  int id, @RequestBody LeaveModel leave){
         String response=leaveService.applyLeave(id,leave);
         if(response.equals("leave applied successfully"))
            return new ResponseEntity<>(response,HttpStatus.OK);
         else
             return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }

    @GetMapping("leaves/{id}")
    public List<Optional<LeaveModel>> getLeaveById(@PathVariable int id){
        List<Optional<LeaveModel>> response =leaveService.getLeaveById(id);
        return response;
    }

    @PostMapping("add-employee")
    public void addEmployee(@RequestBody EmployeeModel employee){
        System.out.println(employee.toString());
        employeeService.addEmployee(employee);
    }
}
