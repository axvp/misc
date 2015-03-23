/**
 * 
 */
package com.jeeatwork.maven.example.cucumber.spring;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author tom1299
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber"}, 
	features = "classpath:calculator.feature", strict = true, monochrome = true)
public class CalculatorTest {

}
