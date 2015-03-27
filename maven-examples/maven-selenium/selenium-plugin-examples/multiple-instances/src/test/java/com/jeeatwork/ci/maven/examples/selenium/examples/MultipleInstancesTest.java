/**
 * 
 */
package com.jeeatwork.ci.maven.examples.selenium.examples;

import static org.testng.AssertJUnit.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author tom1299
 *
 */
public class MultipleInstancesTest {
	
	private static List<WebDriver> INSTANCES = new ArrayList<WebDriver>();
	
	private static int WEBAPP_PORT = 8080;

	/**
	 * 
	 */
	public MultipleInstancesTest() {
		super();
	}
	
	@BeforeClass
	public static void startSelenium() throws MalformedURLException {
		String webAppPort = System.getProperty("jetty.port");
		if (webAppPort != null) {
			WEBAPP_PORT = Integer.parseInt(webAppPort);
		}
		
		String seleniumServerPort = System.getProperty("selenium.server.port");
		startFirefox(seleniumServerPort);
		startFirefox(seleniumServerPort);
	}

	private static void startFirefox(String seleniumServerPort)
			throws MalformedURLException {
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.firefox();
		INSTANCES.add(new RemoteWebDriver(new URL("http://localhost:"
				+ seleniumServerPort + "/wd/hub"), dr));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() throws Exception {
		String url = "http://localhost:" + WEBAPP_PORT + "/test/index.jsp";
		
		Map<String, String> userInfos = new HashedMap();
		
		int usernumber = 1;
		for (WebDriver webDriver : INSTANCES) {
			webDriver.navigate().to(url);
			
			loginTestUser(usernumber, webDriver);
			
			waitForPage(webDriver);
			
			addUserInfo(userInfos, webDriver);
			
			usernumber++;
		}
		
		assertEquals(2, userInfos.size());
	}

	private void waitForPage(WebDriver webDriver) throws Exception {
		waitForElement(By.id("session.id"), webDriver);
	}

	private void addUserInfo(Map<String, String> userInfos, WebDriver webDriver) {
		String sessionId = webDriver.findElement(By.id("session.id")).getText();
		String userName = webDriver.findElement(By.id("userPrincipal.name")).getText();
		
		System.out.println(String.format("User %s has session id %s", userName, sessionId));
		
		userInfos.put(userName, sessionId);
	}

	private void loginTestUser(int usernumber, WebDriver webDriver) {
		webDriver.findElement(By.id("j_username")).sendKeys(
				"testuser" + usernumber);
		webDriver.findElement(By.id("j_password")).sendKeys(
				"pass");
		webDriver.findElement(By.id("submit")).click();
	}
	
	@AfterClass
	public static void stopSelenium() {
		for (WebDriver webDriver : INSTANCES) {
			webDriver.close();
		}
	}
	
	private WebElement waitForElement(By condition, WebDriver webDriver) throws Exception {
        long end = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < end) {
            WebElement resultElement = null;
			try {
				resultElement = webDriver.findElement(condition);
			}
			catch (Exception e) {
				System.out.println("Exception while waiting for element \"" + condition.toString() + "\": " + e.getMessage());
			}
			
            if (resultElement != null && resultElement.isDisplayed()) {
              return resultElement;
            }
            
            Thread.sleep(500);
        }
        throw new NotFoundException("Could not find element by condition " + condition.toString());
	}
}
