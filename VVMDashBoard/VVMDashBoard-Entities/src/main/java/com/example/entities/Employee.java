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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.example.serializer.JaxbDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.Getter;

@Entity
@Table(name="Employee")
@XmlRootElement
@XmlType(propOrder = {"emp_Id", "emp_Name", "emp_Email", "emp_Salary", "emp_Joining_Date"})
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
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Calcutta")
	@Getter(onMethod_={@XmlJavaTypeAdapter(JaxbDateSerializer.class)})
	private Date emp_Joining_Date;
	 
}
