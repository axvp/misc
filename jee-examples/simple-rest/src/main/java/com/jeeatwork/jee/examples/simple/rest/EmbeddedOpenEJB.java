/**
 * 
 */
package com.jeeatwork.jee.examples.simple.rest;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;

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
	public static void main(String[] args) {
    	Properties p = new Properties();

    	p.put("httpejbd", "cxf-rs");
    	p.put("openejb.embedded.remotable", "true");
    	
    	p.put("log4j.category.OpenEJB.options", "debug");
    	p.put("log4j.category.OpenEJB.startup", "debug");
    	p.put("log4j.category.OpenEJB.startup.config", "debug");
    	
        EJBContainer.createEJBContainer(p).getContext();
	}

}
