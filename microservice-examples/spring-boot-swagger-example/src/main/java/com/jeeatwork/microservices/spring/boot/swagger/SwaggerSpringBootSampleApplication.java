package com.jeeatwork.microservices.spring.boot.swagger;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeeatwork.microservices.spring.boot.swagger.model.Address;
import com.jeeatwork.microservices.spring.boot.swagger.model.AddressType;
import com.jeeatwork.microservices.spring.boot.swagger.model.Customer;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class SwaggerSpringBootSampleApplication {

	@RequestMapping("/helloworld")
	String home() {
		return "Hello World!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customer/{id}")
	Customer customer(@PathVariable String id) {
		return this.getCustomer(id);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SwaggerSpringBootSampleApplication.class, args);
	}

	private Customer getCustomer(String id) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstName("Landon");
		customer.setLastName("Melvin");
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTimeInMillis(969660000000l);
		customer.setDateOfBirth(dateOfBirth);

		Address shippingAddress = new Address();
		shippingAddress.setStreet("352 Oxford Road");
		shippingAddress.setZipCode("WV 26003");
		shippingAddress.setCity("Wheeling");
		shippingAddress.setCountry("USA");

		customer.getAddresses().put(AddressType.SHIPPING, shippingAddress);

		Address billingAddress = new Address();
		billingAddress.setStreet("875 Pine Street");
		billingAddress.setZipCode("NJ 08753");
		billingAddress.setCity("Toms River");
		billingAddress.setCountry("USA");

		customer.getAddresses().put(AddressType.BILLING, billingAddress);

		return customer;
	}
}
