package com.jeeatwork.jee.examples.twophasecommit;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

@Stateless	
public class TwoPhaseCommitMoviesTestEJB {
	
    @Resource
    private DataSource movieDatabase;

    @Resource
    private DataSource movieDatabase2;
    
    @EJB
    private TwoPhaseCommitMovies twoPhaseCommitMovies;
    
    @EJB
    private TwoPhaseCommitMovies twoPhaseCommitMovies2;

	public TwoPhaseCommitMoviesTestEJB() {
		super();
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void testTwoPhaseCommit1() throws Exception {
		
		Movie movie = new Movie("Quentin Tarantino", "Reservoir Dogs", 1992);
		twoPhaseCommitMovies.addMovie(movie, movieDatabase);
		
		List<Movie> movies = twoPhaseCommitMovies.getMovies(movieDatabase);
		
		assertEquals(1, movies.size());
	}

}
