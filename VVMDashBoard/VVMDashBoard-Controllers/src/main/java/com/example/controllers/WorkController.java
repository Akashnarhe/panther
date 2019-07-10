package com.example.controllers;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Work;
import com.example.services.WorkService;

@RestController
@RequestMapping(value = "/rest/api/work")
public class WorkController {
	
	@Autowired
	WorkService workService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public Work getWork(@PathVariable int id) {
		return workService.getWork(id);
	}

}
