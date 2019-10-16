package com.example.controllers;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Employee;
import com.example.servicesimpl.EmployeeServiceImpl;


@RestController
@RequestMapping(value="/rest/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	public void saveEmployee(@RequestBody Employee emp) {
		logger.info(emp.toString());
		employeeServiceImpl.saveEmployee(emp);
	}
	
	@GetMapping(value = "/{emp_Id}", produces = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Employee getEmployee(@PathVariable int emp_Id) {
		logger.info("Employee Id for get " + emp_Id);
		return employeeServiceImpl.getEmployee(emp_Id);
	}

	@GetMapping(value="/get",produces="application/json")
	public String getEmployee() {
		return "I am the Boss..............!";
	}
}
