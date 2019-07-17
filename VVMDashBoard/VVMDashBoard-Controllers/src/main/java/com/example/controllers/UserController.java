package com.example.controllers;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.UserService;
import com.example.tos.UserCto;

@RestController
@RequestMapping(value = "/rest/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public UserCto getUser(@PathVariable int id) {
		UserCto userCto = userService.getUser(id);
		logger.debug("Output :- " + userCto.toString());
		return userCto;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Void> saveUser(@RequestBody UserCto userCto) {
		logger.info(userCto.toString());
		userService.saveUser(userCto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
