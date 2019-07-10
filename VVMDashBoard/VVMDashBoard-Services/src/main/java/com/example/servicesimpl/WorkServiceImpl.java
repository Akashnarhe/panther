package com.example.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.WorkRepository;
import com.example.entities.Work;
import com.example.services.WorkService;

@Service
public class WorkServiceImpl implements WorkService {
	
	@Autowired
	WorkRepository workRepository;
	
	@Override
	public Work getWork(int id) {
		return workRepository.findById(id).get();
	}

}
