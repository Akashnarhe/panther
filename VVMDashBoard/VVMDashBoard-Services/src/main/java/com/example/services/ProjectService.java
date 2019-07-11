package com.example.services;

import com.example.entities.Project;

public interface ProjectService {
	Project getProject(int id);
	void saveProject(Project project);
}
