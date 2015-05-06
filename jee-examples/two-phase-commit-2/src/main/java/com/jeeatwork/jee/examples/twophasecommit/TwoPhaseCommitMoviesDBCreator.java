/**
 * 
 */
package com.jeeatwork.jee.examples.twophasecommit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

/**
 * @author tom1299
 *
 */
@Stateless
public class TwoPhaseCommitMoviesDBCreator {
	
    @Resource
    private DataSource movieDatabase;
    
    @Resource
    private DataSource movieDatabase2;

	/**
	 * 
	 */
	public TwoPhaseCommitMoviesDBCreator() {
		super();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createDatabases() throws Exception {
        Connection connection = movieDatabase.getConnection();
        createDatabase(connection);
        connection = movieDatabase2.getConnection();
        createDatabase(connection);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void dropDatabases() throws Exception {
        Connection connection = movieDatabase.getConnection();
        dropDatabase(connection);
        connection = movieDatabase2.getConnection();
        dropDatabase(connection);
	}


	private void createDatabase(Connection connection) throws SQLException {
		try {
            PreparedStatement stmt = connection.prepareStatement("CREATE TABLE movie ( director VARCHAR(255), title VARCHAR(255), year integer)");
            stmt.execute();
        }
        finally {
            connection.close();
        }
	}
	
	private void dropDatabase(Connection connection) throws SQLException {
		try {
            PreparedStatement stmt = connection.prepareStatement("DROP TABLE movie");
            stmt.execute();
        }
        finally {
            connection.close();
        }
	}


}
