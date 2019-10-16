package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id")
	private int userId;

	@Column(name = "User_Name")
	private String userName;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private List<Project> projects = new ArrayList<>();

	public void addProject(Project project) {
		projects.add(project);
		project.setUser(this);
	}

	public void removeProject(Project project) {
		projects.remove(project);
		project.setUser(null);
	}
}
