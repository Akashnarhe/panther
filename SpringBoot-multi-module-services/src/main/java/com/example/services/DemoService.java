package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.DemoDao;

@Service
public class DemoService {
	
	@Autowired
	DemoDao demoDao;
	
	public String getDemoString() {
		return demoDao.getDemoString();
	}
	
}
