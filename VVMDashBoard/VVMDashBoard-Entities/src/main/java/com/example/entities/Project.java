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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "Project")
@Data
public class Project {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Project_Id")
	private int projectId;

	@Column(name = "Project_Name")
	private String projectName;

	@Getter(onMethod_ = { @JsonIgnore })
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private User user = new User();

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private List<Work> works = new ArrayList<>();

	public void addWork(Work work) {
		works.add(work);
		work.setProject(this);
	}

	public void removeWork(Work work) {
		works.remove(work);
		work.setProject(null);
	}

}
