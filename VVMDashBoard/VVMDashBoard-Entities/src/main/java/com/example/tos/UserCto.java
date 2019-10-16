package com.example.tos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class UserCto {
	
	private UserTo user;
	private List<ProjectCto> projects;
	
}
