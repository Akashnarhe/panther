package com.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;

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

	//@Getter(onMethod_ = { @JsonIgnore })
	@ManyToOne()
	@JoinColumn(name = "Project_Id")
	private Project project = new Project();

}
