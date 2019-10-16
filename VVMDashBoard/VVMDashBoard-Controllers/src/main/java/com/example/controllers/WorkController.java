package com.example.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.WorkService;
import com.example.tos.WorkTo;

@RestController
@RequestMapping(value = "/rest/api/work")
public class WorkController {
	
	@Autowired
	WorkService workService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public WorkTo getWork(@PathVariable int id) {
		return workService.getWork(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public List<WorkTo> getAllWork(){
		return workService.getAllWork();
	}

}
