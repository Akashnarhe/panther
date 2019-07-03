package com.example.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Employee;

public interface EmployeeeRepository extends JpaRepository<Employee, Integer>{

}
