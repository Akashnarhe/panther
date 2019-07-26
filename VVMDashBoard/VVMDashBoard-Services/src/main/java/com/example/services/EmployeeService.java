package com.example.services;

import com.example.entities.Employee;

public interface EmployeeService {
	void saveEmployee(Employee emp);
	Employee getEmployee(int emp_Id);
}
