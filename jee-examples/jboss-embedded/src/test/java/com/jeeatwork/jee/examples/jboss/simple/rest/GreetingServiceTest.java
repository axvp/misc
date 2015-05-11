/**
 * 
 */
package com.jeeatwork.jee.examples.jboss.simple.rest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author tom1299
 *
 */
@RunWith(Arquillian.class)
public class GreetingServiceTest {

	@Inject
	GreetingService greetingService;

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		WebArchive webapp = ShrinkWrap.create(WebArchive.class,
				"jboss-embedded-web.war").addClass(GreetingService.class);
		webapp.setWebXML(new File(
				"/home/reuhl/git/misc/jee-examples/jboss-embedded/src/test/resources/web.xml"));
		return webapp;
	}

	public void testEJB() {
		String message = this.greetingService.message();
		assertEquals("Hi REST!", message);
	}

	@Test
	public void create_account_validation_test(@ArquillianResource URL baseURI) {
		System.out.println(baseURI);
	}
}
