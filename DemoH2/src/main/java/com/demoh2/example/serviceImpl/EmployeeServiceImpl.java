package com.demoh2.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demoh2.example.daoImpl.EmployeeDaoImpl;
import com.demoh2.example.entity.Employee;
import com.demoh2.example.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDaoImpl employeeDaoImpl;
	
	public void createEmployee(Employee emp) {
		employeeDaoImpl.createEmployee(emp);
	}

	public Employee findById(int id) {
		return employeeDaoImpl.findById(id);
	}

	public List<Employee> getAllEmployee() {
		return employeeDaoImpl.getAllEmployee();
	}

	public Employee updateEmployee(Employee emp) {
		return employeeDaoImpl.updateEmployee(emp);
	}

	public void deleteEmployee(Employee emp) {
		employeeDaoImpl.deleteEmployee(emp);
	}

}
