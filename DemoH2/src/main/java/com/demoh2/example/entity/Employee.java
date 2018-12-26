package com.demoh2.example.entity;

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

@Entity
@Table(name="employee")
@XmlRootElement
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Emp_ID")
	private int id;
	
/*	if wanted to perform unidirectional mapping then uncomment this and comment below company variables code
 *  and generate getters and setters along with toString(),equals() and hashCode() methods.
    @Column(name="Comp_ID")
	private int cId;*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Comp_ID")
	private Company company;
	
	@Column(name="Emp_Name")
	private String eName;
	
	@Column(name="Emp_Email")
	private String eEmail;
	
	@Column(name="Emp_Salary")
	private int eSalary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", company=");
		builder.append(company);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((eEmail == null) ? 0 : eEmail.hashCode());
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + eSalary;
		result = prime * result + id;
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
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (eEmail == null) {
			if (other.eEmail != null)
				return false;
		} else if (!eEmail.equals(other.eEmail))
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (eSalary != other.eSalary)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
