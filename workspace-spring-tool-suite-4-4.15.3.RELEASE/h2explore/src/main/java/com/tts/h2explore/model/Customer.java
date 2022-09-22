package com.tts.h2explore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //tells JPA that customer objects are something we want to persist and store permanently to the database
public class Customer {
	@Id //mark whatever is annotated as the primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //id will hold database primary key
	private String firstName;
	private String lastName;
	
	public Customer() {
		//all classes with @Entity must have no argument constructor
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

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
