package com.jeeatwork.microservices.spring.boot.swagger;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Customer {
	
	private String firstName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	private Map<AddressType, Address> addresses;

	public Customer() {
		super();
	}

}
