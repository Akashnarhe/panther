package com.example.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@Table(name="Employee")
@XmlRootElement
public class Employee implements Serializable {

	private static final long serialVersionUID = 2030493900910536974L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Emp_Id",nullable=false, unique=true)
	private int eId;
	
	@Column(name="Emp_Name")
	private String eName;
	
	@Column(name="Emp_Email")
	private String eEmail;
	
	@Column(name="Emp_Salary")
	private long eSalary;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public long geteSalary() {
		return eSalary;
	}

	public void seteSalary(long eSalary) {
		this.eSalary = eSalary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eEmail == null) ? 0 : eEmail.hashCode());
		result = prime * result + eId;
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + (int) (eSalary ^ (eSalary >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (eEmail == null) {
			if (other.eEmail != null)
				return false;
		} else if (!eEmail.equals(other.eEmail))
			return false;
		if (eId != other.eId)
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (eSalary != other.eSalary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [eId=");
		builder.append(eId);
		builder.append(", eName=");
		builder.append(eName);
		builder.append(", eEmail=");
		builder.append(eEmail);
		builder.append(", eSalary=");
		builder.append(eSalary);
		builder.append("]");
		return builder.toString();
	}
	
}
