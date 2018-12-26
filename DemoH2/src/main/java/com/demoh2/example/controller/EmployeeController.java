package com.demoh2.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demoh2.example.entity.Employee;
import com.demoh2.example.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public void createEmployee(@RequestBody Employee emp) {
		logger.info("Inside the createEmployee Method emp is " + emp);
		employeeServiceImpl.createEmployee(emp);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
	public Employee findById(@PathVariable int id) {
		logger.info("Inside the findById Method id is " + id);
		return employeeServiceImpl.findById(id);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getAllEmployee() {
		logger.info("Inside the getAllEmployee Method");
		return employeeServiceImpl.getAllEmployee();
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Employee updateEmployee(@RequestBody Employee emp) {
		logger.info("Inside the updateEmployee Method emp is " + emp);
		return employeeServiceImpl.updateEmployee(emp);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = "application/json")
	public void deleteEmployee(@RequestBody Employee emp) {
		logger.info("Inside the deleteEmployee Method emp is " + emp);
		employeeServiceImpl.deleteEmployee(emp);
	}
	
	@RequestMapping(value="/showMessage", method=RequestMethod.GET)
	public ModelAndView showMessage(ModelAndView showMessage) {
		logger.info("Inside the showMessage method");
		showMessage.addObject("message", "Good Morning...............!");
		return showMessage;
	}
}
