package com.example.services;

import com.example.tos.ProjectCto;

public interface ProjectService {
	ProjectCto getProject(int id);
	void saveProject(ProjectCto projectCto);
}
