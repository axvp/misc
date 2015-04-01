/**
 * 
 */
package com.jeeatwork.maven.example.cucumber.testng3;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author tom1299
 *
 */
@Test
@CucumberOptions(plugin = { "pretty", "html:target/cucumber3"}, 
	features = "classpath:calculator3.feature", strict = true, monochrome = true)
public class CalculatorTest3 extends AbstractTestNGCucumberTests {
}
