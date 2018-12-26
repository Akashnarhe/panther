package com.demoh2.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demoh2.example.entity.Company;
import com.demoh2.example.serviceImpl.CompanyServiceImpl;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	CompanyServiceImpl companyServiceImpl;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public void createCompany(@RequestBody Company company) {
		logger.info("Inside the method creatCompany Company is " + company);
		companyServiceImpl.createCompany(company);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	public List<Company> getAllCompanyDetails() {
		logger.info("Inside the method getAllCompanyDetails");
		return companyServiceImpl.getAllCompanyDetails();
	}
}
