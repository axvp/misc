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
	
	public static enum DB {
		MOVIES1,
		MOVIES2
	}
	
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
	public void addMovie(List<Movie> movies, DB db, boolean throwException) throws Exception {
		DataSource dataSource = this.getDataSource(db);
		for (Movie movie : movies) {
			this.twoPhaseCommitMovies.addMovie(movie, dataSource, throwException);
		}
	}
	
	private DataSource getDataSource(DB db) throws Exception {
		if (db.equals(DB.MOVIES1)) {
			return movieDatabase;
		}
		else if (db.equals(DB.MOVIES2)) {
			return movieDatabase2;
		}
		else {
			throw new Exception("No datasource found for db " + db);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteMovie(Movie movie, DB db, boolean throwException) throws Exception {
		DataSource dataSource = this.getDataSource(db);
		this.twoPhaseCommitMovies.deleteMovie(movie, dataSource, throwException);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Movie> getMovies(DB db) throws Exception {
		DataSource dataSource = this.getDataSource(db);
		return this.twoPhaseCommitMovies.getMovies(dataSource);
	}
}
