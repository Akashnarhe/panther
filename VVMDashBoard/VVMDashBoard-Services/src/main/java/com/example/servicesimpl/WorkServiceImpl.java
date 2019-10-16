package com.example.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.WorkRepository;
import com.example.entities.Work;
import com.example.services.WorkService;
import com.example.tos.WorkTo;

@Service
public class WorkServiceImpl implements WorkService {
	
	@Autowired
	WorkRepository workRepository;
	
	@Override
	public WorkTo getWork(int id) {
		WorkTo workTo = new WorkTo();
		Work work = workRepository.findById(id).get();
		
		workTo.setWorkId(work.getWorkId());
		workTo.setWorkName(work.getWorkName());
		
		return workTo;
	}

}
