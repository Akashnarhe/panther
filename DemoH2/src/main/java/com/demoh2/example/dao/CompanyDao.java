package com.demoh2.example.dao;

import java.util.List;

import com.demoh2.example.entity.Company;

public interface CompanyDao {
	void createCompany(Company company);
	List<Company> getAllCompanyDetails();
}
