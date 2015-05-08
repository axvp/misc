package com.jeeatwork.jee.examples.simple.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleRESTEJBTest {

    private static Context context;

    private static SimpleRESTEJB restEJB;

    @BeforeClass
    public static void startTheContainer() throws Exception {
    	Properties p = new Properties();

    	p.put("httpejbd", "cxf-rs");
    	p.put("openejb.embedded.remotable", "true");
    	
        context = EJBContainer.createEJBContainer(p).getContext();
        
        Object object = context.lookup("java:global/simple-rest/SimpleRESTEJB");

        assertTrue(object instanceof SimpleRESTEJB);

        restEJB = (SimpleRESTEJB) object;
    }

    /**
     * Test Add method
     */
    @Test
    public void test() {
    	String messageFromEJB = restEJB.ejb();
    	assertNotNull(messageFromEJB);
    	System.out.println(messageFromEJB);
    	
        String messageFromRESTService = WebClient.create("http://localhost:4204").path("/simple-rest/ejb/").get(String.class);
        assertEquals(messageFromEJB, messageFromRESTService);
        System.out.println(messageFromRESTService);
    }

}
