/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
//START SNIPPET: code
package com.jeeatwork.jee.examples.twophasecommit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

@Stateless
public class TwoPhaseCommitMovies {

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addMovie(Movie movie, DataSource movieDatabase, boolean throwException) throws Exception {
		Connection conn = movieDatabase.getConnection();
		try {
			PreparedStatement sql = conn
					.prepareStatement("INSERT into movie (director, title, year) values (?, ?, ?)");
			sql.setString(1, movie.getDirector());
			sql.setString(2, movie.getTitle());
			sql.setInt(3, movie.getYear());
			sql.execute();
		} finally {
			conn.close();
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteMovie(Movie movie, DataSource movieDatabase, boolean throwException) throws Exception {
		Connection conn = movieDatabase.getConnection();
		try {
			PreparedStatement sql = conn
					.prepareStatement("DELETE from movie where director = ? AND title = ? AND year = ?");
			sql.setString(1, movie.getDirector());
			sql.setString(2, movie.getTitle());
			sql.setInt(3, movie.getYear());
			sql.execute();
		} finally {
			conn.close();
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Movie> getMovies(DataSource movieDatabase) throws Exception {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		Connection conn = movieDatabase.getConnection();
		try {
			PreparedStatement sql = conn
					.prepareStatement("SELECT director, title, year from movie");
			ResultSet set = sql.executeQuery();
			while (set.next()) {
				Movie movie = new Movie();
				movie.setDirector(set.getString("director"));
				movie.setTitle(set.getString("title"));
				movie.setYear(set.getInt("year"));
				movies.add(movie);
			}

		} finally {
			conn.close();
		}
		return movies;
	}

}
