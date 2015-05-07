package com.jeeatwork.jee.examples.simple.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleRESTEJBTest {

    private static EJBContainer ejbContainer;

    private SimpleRESTEJB restEJB;

    @BeforeClass
    public static void startTheContainer() {
        ejbContainer = EJBContainer.createEJBContainer();
    }

    @Before
    public void lookupABean() throws NamingException {
        Object object = ejbContainer.getContext().lookup("java:global/simple-rest/SimpleRESTEJB");

        assertTrue(object instanceof SimpleRESTEJB);

        restEJB = (SimpleRESTEJB) object;
    }

    @AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

    /**
     * Test Add method
     */
    @Test
    public void test() {
    	String message = this.restEJB.ejb();
    	assertNotNull(message);
    }

}
