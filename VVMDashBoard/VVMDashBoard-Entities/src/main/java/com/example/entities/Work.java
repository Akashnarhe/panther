package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Work")
@Data
public class Work {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Work_Id")
	private int workId;

	@Column(name = "Work_Name")
	private String workName;

	@ManyToOne()
	@JoinColumn(name = "Project_Id")
	private Project project = new Project();

}
