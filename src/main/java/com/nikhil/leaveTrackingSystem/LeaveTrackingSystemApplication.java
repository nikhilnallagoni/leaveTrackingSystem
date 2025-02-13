package com.nikhil.leaveTrackingSystem;

import com.nikhil.leaveTrackingSystem.controller.LeaveController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeaveTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveTrackingSystemApplication.class, args);
	}

}
