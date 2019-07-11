package com.example.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.ProjectRepository;
import com.example.entities.Project;
import com.example.entities.User;
import com.example.entities.Work;
import com.example.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project getProject(int id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public void saveProject(Project project) {
		Project project2 = new Project();

		project2.setProjectId(project.getProjectId());
		project2.setProjectName(project.getProjectName());
		
		System.out.println("1 :- " + project2.toString());
		
		List<Work> workList = project.getWorks();
		for (Work work : workList) {
			project2.addWork(work);
		}
		/*User user = project.getUser();
		User user2 = new User();
		user2.setUserId(user.getUserId());
		user2.setUserName(user.getUserName());
		user2.addProject(project2);
		
		project2.setUser(user2);*/
		System.out.println("2 :- " + project2.toString());
		projectRepository.save(project2);
	}

}
