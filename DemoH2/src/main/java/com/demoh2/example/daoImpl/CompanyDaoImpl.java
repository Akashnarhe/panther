package com.demoh2.example.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoh2.example.dao.CompanyDao;
import com.demoh2.example.entity.Company;
import com.demoh2.example.entity.Employee;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	private static final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void createCompany(Company company) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Company company2 = new Company();
		company2.setcName(company.getcName());
		List<Employee> employees = company.getEmployees();
		for (Employee employee : employees) {
			company2.addEmployee(employee);
		}

		session.save(company2);
		session.getTransaction().commit();
	}

	@Override
	public List<Company> getAllCompanyDetails() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Company> company = session.createQuery("from Company").list();
		logger.info("returning from DB " + company);
		session.getTransaction().commit();
		return company;
	}

}
