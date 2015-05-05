/**
 * 
 */
package com.jeeatwork.jee.examples.twophasecommit;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

/**
 * @author tom1299
 *
 */
@Stateless
public class TwoPhaseCommitMoviesFacade {
	
    @EJB
    private TwoPhaseCommitMovies twoPhaseCommitMovies;
    
    @Resource
    private DataSource movieDatabase;

    @Resource
    private DataSource movieDatabase2;


	/**
	 * 
	 */
	public TwoPhaseCommitMoviesFacade() {
		super();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertIntoFirstDB(List<Movie> movies, boolean throwException) throws Exception {
		for (Movie movie : movies) {
			this.twoPhaseCommitMovies.addMovie(movie, movieDatabase);
		}
		
		if (throwException) {
			throw new Exception();
		}
	}

}
