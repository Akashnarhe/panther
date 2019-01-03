package com.demoh2.example.entity;

import java.io.Serializable;

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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonValue;

@Entity
@Table(name = "employee")
@XmlRootElement
public class Employee implements Serializable {

	private static final long serialVersionUID = 7679620555959552912L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Emp_ID", unique = true, nullable = false)
	private int eid;

	/*
	 * if wanted to perform unidirectional mapping then uncomment this and comment
	 * below company variables code and generate getters and setters along with
	 * toString(),equals() and hashCode() methods.
	 * 
	 * @Column(name="Comp_ID") private int cId;
	 */

	@Column(name = "Emp_Name")
	private String eName;

	@Column(name = "Emp_Email")
	private String eEmail;

	@Column(name = "Emp_Salary")
	private int eSalary;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Comp_ID", nullable = false)
	private Company company = new Company();

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	public int geteSalary() {
		return eSalary;
	}

	public void seteSalary(int eSalary) {
		this.eSalary = eSalary;
	}

	@JsonGetter(value = "cid")
	public int getCompanyCid() {
		return company.getCid();
	}

	@JsonGetter(value = "cName")
	public String getCompanyCname() {
		return company.getcName();
	}

	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [eid=");
		builder.append(eid);
		builder.append(", eName=");
		builder.append(eName);
		builder.append(", eEmail=");
		builder.append(eEmail);
		builder.append(", eSalary=");
		builder.append(eSalary);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Employee)) {
			return false;
		}
		return true;
	}
}
