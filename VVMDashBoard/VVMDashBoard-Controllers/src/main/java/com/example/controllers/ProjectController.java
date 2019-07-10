package com.example.controllers;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Project;
import com.example.services.ProjectService;

@RestController
@RequestMapping(value = "/rest/api/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public Project getUser(@PathVariable int id) {
		return projectService.getProject(id);
	}
}
