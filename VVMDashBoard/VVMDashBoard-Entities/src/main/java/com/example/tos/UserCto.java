package com.example.tos;

import java.util.List;

import lombok.Data;

@Data
public class UserCto {
	
	private UserTo user;
	private List<ProjectCto> projects;
	
}
