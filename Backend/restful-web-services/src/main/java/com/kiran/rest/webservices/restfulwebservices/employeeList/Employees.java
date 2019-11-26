package com.kiran.rest.webservices.restfulwebservices.employeeList;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Employees {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String FirstName;
	private String LastName;
	private String Gender;
	private Date DateOfBirth;
	private String Department;
	
	protected Employees(){
		
	}
	
	public Employees(long id, String firstName, String lastName, String gender, Date dateOfBirth, String department) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		DateOfBirth = dateOfBirth;
		Department = department;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getGender() {
		return Gender;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public String getDepartment() {
		return Department;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public void setDepartment(String department) {
		Department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Employees other = (Employees) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
