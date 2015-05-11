/**
 * 
 */
package com.jeeatwork.jee.examples.jboss.simple.rest;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
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

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(GreetingService.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void test() {
		String message = this.greetingService.message();
		assertEquals("Hi REST!", message);
	}

}
