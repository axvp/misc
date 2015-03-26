/**
 * 
 */
package com.jeeatwork.ci.maven.examples.selenium.examples;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author tom1299
 *
 *         A first test using selenium for a multipe browsers.
 */
public class MultipleBrowserTest {

	private static WebDriver FIREFOX;
	private static WebDriver CHROME;

	/**
	 * 
	 */
	public MultipleBrowserTest() {
		super();
	}

	@BeforeClass
	public static void startSelenium() throws MalformedURLException {
		String seleniumServerPort = System.getProperty("selenium.server.port");
		startFirefox(seleniumServerPort);
		startChrome(seleniumServerPort);
	}

	private static void startFirefox(String seleniumServerPort)
			throws MalformedURLException {
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.firefox();
		FIREFOX = new RemoteWebDriver(new URL("http://localhost:"
				+ seleniumServerPort + "/wd/hub"), dr);
	}
	
	private static void startChrome(String seleniumServerPort)
			throws MalformedURLException {
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.chrome();
		CHROME = new RemoteWebDriver(new URL("http://localhost:"
				+ seleniumServerPort + "/wd/hub"), dr);
	}

	@AfterClass
	public static void stopSelenium() {
		FIREFOX.close();
		CHROME.close();
	}

	@Test
	public void testGoogle() {
		
		WebDriver[] drivers = new WebDriver[]{FIREFOX, CHROME};
		
		for (WebDriver webDriver : drivers) {
			webDriver.navigate().to("http://www.google.de");
			webDriver.findElement(By.id("lst-ib")).sendKeys(
					"selenium\n");			
		}
	}
}
