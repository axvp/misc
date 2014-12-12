/**
 * 
 */
package de.telekom.pd.soap;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import de.telekom.pd.Fibonacci;

/**
 * @author reuhl
 *
 */
@WebService(name="Fibonacci")
public class FibonacciSOAPAdapter {
	
	private Fibonacci fibonacci;

	/**
	 * 
	 */
	public FibonacciSOAPAdapter() {
		super();
		this.fibonacci = new Fibonacci();
	}

	@WebMethod
	public @WebResult(name="sequence")List<Long> getSequence(@WebParam(name="sequenceLength")int sequenceLength) {
		Long[] sequence = this.fibonacci.calculateSequence(sequenceLength);
		FibonacciSequence response = new FibonacciSequence();
		response.setSequence(Arrays.asList(sequence));
		return Arrays.asList(sequence);
	}
}
