package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping(value="/save", consumes="application/json")
	public void saveEmployee(@RequestBody Employee emp) {
		employeeServiceImpl.saveEmployee(emp);
	}

	@GetMapping(value="/get",produces="application/json")
	public String getEmployee() {
		return "I am the Boss..............!";
	}
}
