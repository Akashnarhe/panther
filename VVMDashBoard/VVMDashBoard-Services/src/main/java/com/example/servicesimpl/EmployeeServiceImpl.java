package com.example.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.EmployeeRepository;
import com.example.entities.Employee;
import com.example.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

}
