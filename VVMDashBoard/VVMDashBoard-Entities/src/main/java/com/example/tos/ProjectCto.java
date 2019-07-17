package com.example.tos;

import java.util.List;

import lombok.Data;

@Data
public class ProjectCto {
	
	private ProjectTo project;
	private List<WorkTo> works;
	
}
