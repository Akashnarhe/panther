package com.example.servicesimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.ProjectRepository;
import com.example.entities.Project;
import com.example.entities.User;
import com.example.entities.Work;
import com.example.services.ProjectService;
import com.example.tos.ProjectCto;
import com.example.tos.ProjectTo;
import com.example.tos.WorkTo;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public ProjectCto getProject(int id) {
		ProjectCto projectCto = new ProjectCto();
		ProjectTo projectTo = new ProjectTo();
		ArrayList<WorkTo> workToList = new ArrayList<>();
		
		Project project = projectRepository.findById(id).get();
		
		projectTo.setProjectId(project.getProjectId());
		projectTo.setProjectName(project.getProjectName());
		projectCto.setProject(projectTo);
		
		HashSet<Work> workList = new HashSet<>(project.getWorks());
		
		for (Work work : workList) {
			WorkTo workTo = new WorkTo();
			workTo.setWorkId(work.getWorkId());
			workTo.setWorkName(work.getWorkName());
			workToList.add(workTo);
		}
		projectCto.setWorks(workToList);
		
		return projectCto;
	}

	@Override
	public void saveProject(ProjectCto projectCto) {
		Project project2 = new Project();

		project2.setProjectId(projectCto.getProject().getProjectId());
		project2.setProjectName(projectCto.getProject().getProjectName());
		
		List<WorkTo> workToList = projectCto.getWorks();
		
		for (WorkTo workTo : workToList) {
			Work work = new Work();
			work.setWorkId(workTo.getWorkId());
			work.setWorkName(workTo.getWorkName());
			
			project2.addWork(work);
		}
		
		User user2 = new User();
		user2.setUserId(0);
		user2.setUserName("Default");
		user2.addProject(project2);
		
		project2.setUser(user2);
		projectRepository.save(project2);
	}

}
