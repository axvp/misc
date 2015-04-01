/**
 * 
 */
package com.jeeatwork.maven.example.cucumber.testng3;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.jeeatwork.maven.example.cucumber.testng.Calculator;
import com.jeeatwork.maven.example.cucumber.testng.components.DefaultCalculatorImpl;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author tom1299
 *
 */
public class CalculatorSteps3 {

	private Calculator calculator;

	private List<Long> calculatedResults = new ArrayList<Long>();

	@Given("^I have a calculator$")
	public void i_have_a_calculator() throws Throwable {
		this.calculator = new DefaultCalculatorImpl();
	}

	@When("^I add two numbers:$")
	public void i_add_two_numbers(DataTable numbersTable) throws Throwable {
		List<List<String>> table = numbersTable.cells(0);

		table.forEach(numbers -> addTwoNumbers(numbers));
	}

	@Then("^the result should be:$")
	public void the_result_should_be(DataTable result) throws Throwable {
		List<String> table = result.asList(String.class);

		for (int i = 0; i < table.size(); i++) {
			Long expectedResult = Long.parseLong(table.get(i));
			Long actualResult = this.calculatedResults.get(i);
			assertEquals(expectedResult, actualResult);
		}
	}

	private void addTwoNumbers(List<String> numbers) {
		long firstNumber = Long.parseLong(numbers.get(0));
		long secondNumber = Long.parseLong(numbers.get(1));
		this.calculatedResults.add(this.calculator.add(firstNumber,
				secondNumber));
	}
}
