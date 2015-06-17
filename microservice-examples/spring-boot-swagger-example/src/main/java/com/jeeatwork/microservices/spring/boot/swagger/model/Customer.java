package com.jeeatwork.microservices.spring.boot.swagger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Customer {

	private String id;

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private Map<AddressType, Address> addresses = new HashMap<AddressType, Address>();

	public Customer() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Map<AddressType, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<AddressType, Address> addresses) {
		this.addresses = addresses;
	}

}
