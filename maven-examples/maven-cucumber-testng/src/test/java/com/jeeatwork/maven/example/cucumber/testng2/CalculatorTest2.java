/**
 * 
 */
package com.jeeatwork.maven.example.cucumber.testng2;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author tom1299
 *
 */
@CucumberOptions(plugin = { "pretty", "html:target/cucumber2"}, 
	features = "classpath:calculator2.feature", strict = true, monochrome = true)
public class CalculatorTest2 extends AbstractTestNGCucumberTests {
}
