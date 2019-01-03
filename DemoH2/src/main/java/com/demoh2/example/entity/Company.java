package com.demoh2.example.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "company")
@XmlRootElement
public class Company implements Serializable {

	private static final long serialVersionUID = 224117223595682766L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Comp_ID", unique = true, nullable = false)
	private int cid;

	@Column(name = "Comp_Name")
	private String cName;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinColumn(name="Comp_ID") for unidirectional mapping uncomment this line
	List<Employee> employees = new ArrayList<>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee employee) {
		employee.setCompany(this);
		this.employees.add(employee);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Company [cid=");
		builder.append(cid);
		builder.append(", cName=");
		builder.append(cName);
		builder.append("]");
		return builder.toString();
	}

}
