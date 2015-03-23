/**
 * 
 */
package com.jeeatwork.maven.example.cucumber.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author tom1299
 *
 */
public class CalculatorSteps {
	
	@Autowired
	Calculator calculator;
	
	private long result;

	@Given("^I have a calculator$")
	public void i_have_a_calculator() throws Throwable {
		assertNotNull(this.calculator);
	}

	@When("^I add (\\d+) and (\\d+)$")
	public void i_add_and(int arg1, int arg2) throws Throwable {
		this.result = this.calculator.add(arg1, arg2);
	}

	@Then("^the result should be (\\d+)$")
	public void the_result_should_be(int arg1) throws Throwable {
		assertEquals(this.result, arg1);
	}

}
