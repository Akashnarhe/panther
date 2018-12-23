package com.demoh2.example.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoh2.example.dao.EmployeeDao;
import com.demoh2.example.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;

	public void createEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
	}

	public Employee findById(int id) {
		Employee employee = new Employee();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		employee = session.get(Employee.class, id);
		session.getTransaction().commit();
		return employee;
	}

	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Employee> emp = session.createQuery("From Employee").list();
		session.getTransaction().commit();
		return emp;
	}

	public Employee updateEmployee(Employee emp) {
		Employee employee = new Employee();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		employee = session.get(Employee.class, emp.getId());
		System.out.println("Input employee :- " + emp);
		System.out.println("outside of if employee :- " + employee);
		if (!employee.equals(emp)) {
			employee.seteName(emp.geteName());
			employee.seteEmail(emp.geteEmail());
			employee.seteSalary(emp.geteSalary());
			System.out.println("inside of if employee :- " + employee);
			session.merge(employee);
			session.getTransaction().commit();
		} else {
			return emp;
		}
		return employee;
	}

	public void deleteEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete("Employee.class", emp);
		session.getTransaction().commit();
	}

}
