/**
 * 
 */
package com.jeeatwork.maven.example.cucumber.testng;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author tom1299
 *
 */
@Test
@CucumberOptions(plugin = { "pretty", "html:target/cucumber"}, 
	features = "classpath:calculator.feature", strict = true, monochrome = true)
public class CalculatorTest extends AbstractTestNGCucumberTests {
}
