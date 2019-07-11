package com.example.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.UserRepository;
import com.example.entities.Project;
import com.example.entities.User;
import com.example.entities.Work;
import com.example.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectServiceImpl projectServiceImpl;

	@Override
	public User getUser(int id) {
		User user = userRepository.findById(id).get();
		return user;
	}

	@Override
	public void saveUser(User user) {

		User user2 = new User();
		user2.setUserId(user.getUserId());
		user2.setUserName(user.getUserName());

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

		List<Project> projectList = user.getProjects();
		for (Project project : projectList) {

			Project project2 = new Project();
			project2.setProjectId(project.getProjectId());
			project2.setProjectName(project.getProjectName());

			List<Work> workList = project.getWorks();

			for (Work work : workList) {
				project2.addWork(work);
			}
			user2.addProject(project2);
		}

		userRepository.save(user2);
	}

}
