/**
 * 
 */
package com.jeeatwork.jee.examples.jboss.simple.rest;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ws.rs.client.WebTarget;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author tom1299
 *
 */
@RunWith(Arquillian.class)
public class GreetingServiceRESTTest {

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		WebArchive webapp = ShrinkWrap.create(WebArchive.class,
				"jboss-embedded-web.war").addClass(GreetingService.class);
		webapp.setWebXML(new File("src/test/resources/web.xml"));
		return webapp;
	}

	@Test
	public void testREST(@ArquillianResteasyResource WebTarget webTarget) {
		String message = webTarget.path("/greeting").request().get().readEntity(String.class);
		assertEquals("Hi REST!", message);
	}
}
