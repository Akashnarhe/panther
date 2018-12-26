package com.demoh2.example.service;

import java.util.List;

import com.demoh2.example.entity.Company;

public interface CompanyService {
	void createCompany(Company company);
	List<Company> getAllCompanyDetails();
}
