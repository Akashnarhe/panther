package com.example.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "Project")
@Data
public class Project {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Project_Id")
	private int id;

	@Column(name = "Project_Name")
	private String name;
	
	@Getter(onMethod_={@JsonIgnore})
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private User user;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Work> works;
}
