package com.jeeatwork.jee.examples.twophasecommit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jeeatwork.jee.examples.twophasecommit.TwoPhaseCommitMoviesFacade.DB;
import com.jeeatwork.jee.examples.twophasecommit.exceptions.TwoPhaseCommitRuntimeException;

public class TwoPhaseCommitMoviesTest {

	private Context context;
	
	private EJBContainer ejbContainer;

	@Before
	public void initDBs() throws Exception {
		Properties p = new Properties();
		p.put("movieDatabase", "new://Resource?type=DataSource");
		p.put("movieDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("movieDatabase.JdbcUrl", "jdbc:hsqldb:mem:moviedb");

		p.put("movieDatabase2", "new://Resource?type=DataSource");
		p.put("movieDatabase2.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("movieDatabase2.JdbcUrl", "jdbc:hsqldb:mem:moviedb2");

		this.ejbContainer = EJBContainer.createEJBContainer(p);
		this.context = this.ejbContainer.getContext();
		
		TwoPhaseCommitMoviesDBCreator moviesDBCreator = (TwoPhaseCommitMoviesDBCreator) context
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesDBCreator");
		moviesDBCreator.createDatabases();
	}
	
	@After
	public void dropDBS() throws Exception {
		TwoPhaseCommitMoviesDBCreator moviesDBCreator = (TwoPhaseCommitMoviesDBCreator) context
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesDBCreator");
		moviesDBCreator.dropDatabases();
	}

	@Test
	public void test1() throws Exception {
		TwoPhaseCommitMoviesFacade moviesFacade = (TwoPhaseCommitMoviesFacade) context
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesFacade");
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
		
		moviesFacade.addMovie(movies, DB.MOVIES1, false);
		
		List<Movie> movs = moviesFacade.getMovies(DB.MOVIES1);
		assertEquals(1, movs.size());
		
		moviesFacade.deleteMovie(movies.get(0), DB.MOVIES1, false);
		
		movs = moviesFacade.getMovies(DB.MOVIES1);
		assertEquals(0, movs.size());
	}
	
	@Test
	public void test2() throws Exception {
		TwoPhaseCommitMoviesFacade moviesFacade = (TwoPhaseCommitMoviesFacade) context
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesFacade");
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
		
		boolean excpetionThrown = false;
		try {
			moviesFacade.addMovie(movies, DB.MOVIES1, true);
		}
		catch (EJBException e) {
			excpetionThrown = true;
		}
		
		assertTrue(excpetionThrown);
		
		List<Movie> movs = moviesFacade.getMovies(DB.MOVIES1);
		assertEquals(0, movs.size());
	}
	
	@Test
	public void test3() throws Exception {
		TwoPhaseCommitMoviesTestEJB testEJB = (TwoPhaseCommitMoviesTestEJB) context
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesTestEJB");
		
		testEJB.testTwoPhaseCommit1();
	}
	
	@Test
	public void test4() throws Exception {
		TwoPhaseCommitMoviesTestEJB testEJB = (TwoPhaseCommitMoviesTestEJB) context
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesTestEJB");
		
		boolean exception = false;
		try {
			testEJB.testTwoPhaseCommit2();
		}
		catch (EJBException e) {
			assertTrue(e.getCause() instanceof EJBTransactionRolledbackException);
			assertTrue(e.getCause().getCause() instanceof TwoPhaseCommitRuntimeException);
			exception = true;
		}
		
		assertTrue(exception);
		
		TwoPhaseCommitMoviesFacade moviesFacade = (TwoPhaseCommitMoviesFacade) context
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesFacade");
		
		List<Movie> movies = moviesFacade.getMovies(DB.MOVIES1);
		assertEquals(0, movies.size());
	}
}
