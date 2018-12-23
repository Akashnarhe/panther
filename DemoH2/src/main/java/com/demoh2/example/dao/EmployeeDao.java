package com.demoh2.example.dao;

import java.util.List;

import com.demoh2.example.entity.Employee;

public interface EmployeeDao {
	void createEmployee(Employee emp);
	Employee findById(int id);
	List<Employee> getAllEmployee();
	Employee updateEmployee(Employee emp);
	void deleteEmployee(Employee emp);
}
