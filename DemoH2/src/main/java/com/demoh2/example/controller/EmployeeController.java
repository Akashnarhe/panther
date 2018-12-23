package com.demoh2.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demoh2.example.entity.Employee;
import com.demoh2.example.serviceImpl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@RequestMapping(value = "/createemp", method = RequestMethod.POST, consumes = "application/json")
	public void createEmployee(@RequestBody Employee emp) {
		employeeServiceImpl.createEmployee(emp);
	}

	@RequestMapping(value = "/getemp/{id}", method = RequestMethod.GET, produces = "application/json")
	public Employee findById(@PathVariable int id) {
		return employeeServiceImpl.findById(id);
	}

	@RequestMapping(value = "/getallemp", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getAllEmployee() {
		return employeeServiceImpl.getAllEmployee();
	}

	@RequestMapping(value = "/updateemp", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeServiceImpl.updateEmployee(emp);
	}
}
