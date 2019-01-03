package com.demoh2.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demoh2.example.daoImpl.CompanyDaoImpl;
import com.demoh2.example.entity.Company;
import com.demoh2.example.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyDaoImpl companyDaoImpl;

	@Override
	public void createCompany(Company company) {
		companyDaoImpl.createCompany(company);
	}

	@Override
	public List<Company> getAllCompanyDetails() {
		return companyDaoImpl.getAllCompanyDetails();
	}

}
