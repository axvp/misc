package com.jeeatwork.jee.examples.twophasecommit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jeeatwork.jee.examples.twophasecommit.TwoPhaseCommitMoviesFacade.DB;

public class TwoPhaseCommitMoviesTest {

	private static Context TEST_CONTEXT;

	@BeforeClass
	public static void createDBs() throws Exception {
		Properties p = new Properties();
		p.put("movieDatabase", "new://Resource?type=DataSource");
		p.put("movieDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("movieDatabase.JdbcUrl", "jdbc:hsqldb:mem:moviedb");

		p.put("movieDatabase2", "new://Resource?type=DataSource");
		p.put("movieDatabase2.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("movieDatabase2.JdbcUrl", "jdbc:hsqldb:mem:moviedb2");

		TEST_CONTEXT = EJBContainer.createEJBContainer(p).getContext();
		
		TwoPhaseCommitMoviesDBCreator moviesDBCreator = (TwoPhaseCommitMoviesDBCreator) TEST_CONTEXT
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesDBCreator");
		moviesDBCreator.createDatabases();
	}

	@Test
	public void test1() throws Exception {
		TwoPhaseCommitMoviesFacade moviesFacade = (TwoPhaseCommitMoviesFacade) TEST_CONTEXT
				.lookup("java:global/two-phase-commit-2/TwoPhaseCommitMoviesFacade");
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
		
		moviesFacade.addMovie(movies, DB.MOVIES1, false);
		
		List<Movie> movs = moviesFacade.getMovies(DB.MOVIES1);
		assertEquals(1, movs.size());
	}

}
