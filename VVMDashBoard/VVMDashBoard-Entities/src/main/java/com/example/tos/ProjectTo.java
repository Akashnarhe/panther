package com.example.tos;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class ProjectTo {
	
	private int projectId;
	private String projectName;
	
}
