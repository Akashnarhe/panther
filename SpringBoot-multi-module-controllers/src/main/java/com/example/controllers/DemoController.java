package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.services.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@GetMapping(value="/demo", produces="application/json")
	public String getDemoString() {
		return demoService.getDemoString();
	}
	
	@GetMapping(value="/")
	public String welcomePage() {
		return "I am the Boss.........!";
	}
}
