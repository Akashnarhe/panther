package com.example.services;

import java.util.List;

import com.example.tos.ProjectCto;

public interface ProjectService {
	ProjectCto getProject(int id);
	List<ProjectCto> getAllProjects();
	void saveProject(ProjectCto projectCto);
	void deleteProject(int id);
}
