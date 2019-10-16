package com.example.servicesimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.UserRepository;
import com.example.entities.Project;
import com.example.entities.User;
import com.example.entities.Work;
import com.example.services.UserService;
import com.example.tos.ProjectCto;
import com.example.tos.ProjectTo;
import com.example.tos.UserCto;
import com.example.tos.UserTo;
import com.example.tos.WorkTo;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserCto getUser(int id) {
		UserCto userCto = new UserCto();
		UserTo userTo = new UserTo();
		List<ProjectCto> projectCtoList = new ArrayList<>();
		
		User user = userRepository.findById(id).get();
		
		userTo.setUserId(user.getUserId());
		userTo.setUserName(user.getUserName());
		
		userCto.setUser(userTo);

		Set<Project> projectsSet = new HashSet<>(user.getProjects());

		for (Project project : projectsSet) {
			
			ProjectCto projectCto = new ProjectCto();
			ProjectTo projectTo = new ProjectTo();
			List<WorkTo> workToList = new ArrayList<>();
			
			projectTo.setProjectId(project.getProjectId());
			projectTo.setProjectName(project.getProjectName());
			projectCto.setProject(projectTo);
			
			
			for (Work work : project.getWorks()) {
				
				WorkTo workTo = new WorkTo();
				
				workTo.setWorkId(work.getWorkId());
				workTo.setWorkName(work.getWorkName());
				
				workToList.add(workTo);
			}
			projectCto.setWorks(workToList);
			projectCtoList.add(projectCto);
		}
		userCto.setProjects(projectCtoList);
		
		logger.debug(userCto.toString());
		
		return userCto;
	}
	

	@Override
	public void saveUser(UserCto userCto) {

		User user2 = new User();
		user2.setUserId(userCto.getUser().getUserId());
		user2.setUserName(userCto.getUser().getUserName());

		/*
		 * List<Project> projectList = user.getProjects(); ListIterator<Project>
		 * projectIterator = projectList.listIterator();
		 * 
		 * while(projectIterator.hasNext()) { Project project = projectIterator.next();
		 * List<Work> workList = project.getWorks(); Project project2 = new Project();
		 * 
		 * project2.setProjectId(project.getProjectId());
		 * project2.setProjectName(project.getProjectName());
		 * 
		 * ListIterator<Work> workIterator = workList.listIterator();
		 * while(workIterator.hasNext()) { Work work = workIterator.next();
		 * project2.addWork(work); } user2.addProject(project2); }
		 */

		List<ProjectCto> projectList = userCto.getProjects();
		for (ProjectCto project : projectList) {

			Project project2 = new Project();
			project2.setProjectId(project.getProject().getProjectId());
			project2.setProjectName(project.getProject().getProjectName());

			List<WorkTo> workList = project.getWorks();

			for (WorkTo work : workList) {
				Work work2 = new Work();
				work2.setWorkId(work.getWorkId());
				work2.setWorkName(work.getWorkName());
				project2.addWork(work2);
			}
			user2.addProject(project2);
		}

		userRepository.save(user2);
	}
	
	


	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}


	@Override
	public List<UserCto> getAllUsers() {
		List<UserCto> userCtos = new ArrayList<>();
		List<User> users = userRepository.findAll();

		for (User user : users) {
			UserCto userCto = new UserCto();
			UserTo userTo = new UserTo();
			List<ProjectCto> projectCtoList = new ArrayList<>();
			
			userTo.setUserId(user.getUserId());
			userTo.setUserName(user.getUserName());
			
			userCto.setUser(userTo);
			
			Set<Project> projectsSet = new HashSet<>(user.getProjects());

			for (Project project : projectsSet) {
				
				ProjectCto projectCto = new ProjectCto();
				ProjectTo projectTo = new ProjectTo();
				List<WorkTo> workToList = new ArrayList<>();
				
				projectTo.setProjectId(project.getProjectId());
				projectTo.setProjectName(project.getProjectName());
				projectCto.setProject(projectTo);
				
				
				for (Work work : project.getWorks()) {
					
					WorkTo workTo = new WorkTo();
					
					workTo.setWorkId(work.getWorkId());
					workTo.setWorkName(work.getWorkName());
					
					workToList.add(workTo);
				}
				projectCto.setWorks(workToList);
				projectCtoList.add(projectCto);
			}
			userCto.setProjects(projectCtoList);
			userCtos.add(userCto);
		}
		
		return userCtos;
	}

}
