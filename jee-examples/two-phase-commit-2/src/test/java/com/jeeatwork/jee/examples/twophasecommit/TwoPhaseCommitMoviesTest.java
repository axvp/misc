package com.jeeatwork.jee.examples.twophasecommit;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TwoPhaseCommitMoviesTest {
	
	private static Context TEST_CONTEXT;

	@BeforeClass
	public static void createDBs() throws NamingException {
        Properties p = new Properties();
        p.put("movieDatabase", "new://Resource?type=DataSource");
        p.put("movieDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("movieDatabase.JdbcUrl", "jdbc:hsqldb:mem:moviedb");
        
        p.put("movieDatabase2", "new://Resource?type=DataSource");
        p.put("movieDatabase2.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("movieDatabase2.JdbcUrl", "jdbc:hsqldb:mem:moviedb");
		
		TEST_CONTEXT = EJBContainer.createEJBContainer(p).getContext();
	}
	
	@Test
	public void test1() throws Exception {
		
	}

}
