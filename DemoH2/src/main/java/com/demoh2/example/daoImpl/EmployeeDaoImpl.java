package com.demoh2.example.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoh2.example.dao.EmployeeDao;
import com.demoh2.example.entity.Company;
import com.demoh2.example.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;

	public void createEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Employee employee = new Employee();
		employee.seteName(emp.geteName());
		employee.seteEmail(emp.geteEmail());
		employee.seteSalary(emp.geteSalary());
		Company company = new Company();
		company.setcName(emp.getCompany().getcName());
		System.out.println(company);
		company.addEmployee(employee);
		session.save(employee);
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
		List<Employee> employees = new ArrayList<>();
		List<Employee> emp = session.createQuery("From Employee").list();
		for (Employee employee : emp) {
			employees.add(employee);
			System.out.println(employee.getCompany());
		}
		session.getTransaction().commit();
		return employees;
	}

	public Employee updateEmployee(Employee emp) {
		Employee employee = new Employee();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		employee = session.get(Employee.class, emp.getEid());
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
		String hql = "DELETE FROM Employee WHERE Emp_ID = :Emp_id";
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("Emp_id", emp.getEid());
		query.executeUpdate();
		// session.delete("Employee.class", emp);
		session.getTransaction().commit();
	}

}
