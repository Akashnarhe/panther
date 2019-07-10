package com.example.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.ProjectRepository;
import com.example.entities.Project;
import com.example.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project getProject(int id) {
		return projectRepository.findById(id).get();
	}

}
