package com.example.entities;

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

import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id")
	private int id;

	@Column(name = "User_Name")
	private String name;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Project> projects;
}
