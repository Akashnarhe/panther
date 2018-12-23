package com.demoh2.example.service;

import java.util.List;

import com.demoh2.example.entity.Employee;

public interface EmployeeService {
	void createEmployee(Employee emp);
	Employee findById(int id);
	List<Employee> getAllEmployee();
	Employee updateEmployee(Employee emp);
	void deleteEmployee(int id);
}
