package com.example.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="Employee")
@XmlRootElement
@Data
public class Employee implements Serializable {

	private static final long serialVersionUID = 2030493900910536974L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Emp_Id",nullable=false, unique=true)
	private int emp_Id;
	
	@Column(name="Emp_Name")
	private String emp_Name;
	
	@Column(name="Emp_Email")
	private String emp_Email;
	
	@Column(name="Emp_Salary")
	private long emp_Salary;
	
	@Column(name = "Emp_Joining_Date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date emp_Joining_Date;
	 
}
