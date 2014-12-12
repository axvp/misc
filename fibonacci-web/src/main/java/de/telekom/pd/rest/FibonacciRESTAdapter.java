/**
 * 
 */
package de.telekom.pd.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.telekom.pd.Fibonacci;

/**
 * @author reuhl
 *
 */
@Path("/fibonacci")
public class FibonacciRESTAdapter {
	
	private Fibonacci fibonacci;

	/**
	 * 
	 */
	public FibonacciRESTAdapter() {
		super();
		fibonacci = new Fibonacci();
	}
	
	@GET
	@Path("/{sequenceLength}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Long[] calculateSequence(@PathParam("sequenceLength") String sequenceLength) {
		int length = Integer.parseInt(sequenceLength);
		return fibonacci.calculateSequence(length);
	}

}
