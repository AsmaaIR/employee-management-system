package com.employee.management.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.employee.management.system.util.StateEnums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Employee. ")
@Table(name = "employee")
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ApiModelProperty(dataType = "string", name = "firstName", required = true, notes = "Name should have atleast 5 characters")
	@Size(min = 2, message = "Name should have atleast 5 characters")
	@Column(name = "first_name")
	private String firstName;

	@ApiModelProperty(dataType = "string", name = "last_name", required = true, notes = "Name should have atleast 5 characters")
	@Size(min = 2, message = "Name should have atleast 5 characters")
	@Column(name = "last_name")
	private String lastName;

	@ApiModelProperty(dataType = "string", name = "email", value = "name@email.com", required = true, notes = "The email address of the employee Must be in the format of an email address.")
	@Column(name = "email")
	private String email;

	@ApiModelProperty
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "state")
	private StateEnums state;

	// define constructors
	public Employee() {

	}

	// define getter/setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// define tostring

	public StateEnums getState() {
		return state;
	}

	public void setState(StateEnums state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", state=" + state + "]";
	}

}
