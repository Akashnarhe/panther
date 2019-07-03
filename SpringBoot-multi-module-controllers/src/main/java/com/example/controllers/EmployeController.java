package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.daos.EmployeeeRepository;
import com.example.entities.Employee;

@RestController
@RequestMapping(value="/employee")
public class EmployeController {
	
	@Autowired
	EmployeeeRepository employeeeRepository;
	
	@PostMapping(value="/create", consumes = "application/json")
	public void createEmployee(@RequestBody Employee emp) {
		employeeeRepository.save(emp);
	}
}
