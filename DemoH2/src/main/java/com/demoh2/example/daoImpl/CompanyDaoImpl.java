package com.demoh2.example.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoh2.example.dao.CompanyDao;
import com.demoh2.example.entity.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void createCompany(Company company) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(company);
		session.getTransaction().commit();
	}

	@Override
	public List<Company> getAllCompanyDetails() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Company> company = session.createQuery("From Company").list();
		session.getTransaction().commit();
		return company;
	}

}
