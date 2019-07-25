package com.example.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Project;
import com.example.services.ProjectService;
import com.example.tos.ProjectCto;
import com.spotify.docker.client.shaded.javax.ws.rs.GET;

@RestController
@RequestMapping(value = "/rest/api/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public ProjectCto getProject(@PathVariable int id) {
		return projectService.getProject(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Void> saveProject(@RequestBody ProjectCto projectCto) {
		logger.info(projectCto.toString());
		projectService.saveProject(projectCto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable int id) {
		logger.info("Input :- " + id);
		projectService.deleteProject(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public List<ProjectCto> getAllProjects() {
		return projectService.getAllProjects();
	}
	
}
