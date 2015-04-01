/**
 * 
 */
package com.jeeatwork.maven.example.cucumber.spring;

import com.jeeatwork.maven.example.cucumber.spring.components.DefaultCalculatorImpl;

import static org.testng.AssertJUnit.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author tom1299
 *
 */
public class CalculatorSteps {
	
	private long result;
	
	private Calculator calculator;

	@Given("^I have a calculator$")
	public void i_have_a_calculator() throws Throwable {
		this.calculator = new DefaultCalculatorImpl();
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
