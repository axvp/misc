/**
 * 
 */
package com.jeeatwork.jee.examples.simple.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.apache.cxf.jaxrs.client.WebClient;

/**
 * @author tom1299
 *
 */
public class EmbeddedOpenEJB {

	/**
	 * 
	 */
	public EmbeddedOpenEJB() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();

		p.put("httpejbd", "cxf-rs");
		p.put("openejb.embedded.remotable", "true");

//		p.put("log4j.category.OpenEJB.options", "debug");
//		p.put("log4j.category.OpenEJB.startup", "debug");
//		p.put("log4j.category.OpenEJB.startup.config", "debug");

		Context context = EJBContainer.createEJBContainer(p).getContext();

		SimpleRESTEJB object = (SimpleRESTEJB) context
				.lookup("java:global/simple-rest/SimpleRESTEJB");
		assertNotNull(object);

		String messageFromEJB = object.ejb();
		assertNotNull(messageFromEJB);
		System.out.println(messageFromEJB);

		String messageFromRESTService = WebClient
				.create("http://localhost:4204").path("/simple-rest/ejb/")
				.get(String.class);
		
		assertEquals(messageFromEJB, messageFromRESTService);
		System.out.println(messageFromRESTService);
	}

}
