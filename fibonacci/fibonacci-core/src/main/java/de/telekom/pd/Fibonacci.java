/**
 * 
 */
package de.telekom.pd;


/**
 * @author reuhl
 *
 */
public class Fibonacci {

	/**
	 * 
	 */
	public Fibonacci() {
		super();
	}

	private long fib(int n) {
		if (n <= 1) {
			return n;
		}
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public Long[] calculateSequence(int sequenceLength) {
		if (sequenceLength < 0) {
			return new Long[0];
		}
		
		Long[] fibonacciSequence = new Long[sequenceLength];
		for (int i = 0; i < sequenceLength; i++) {
			fibonacciSequence[i] = this.fib(i);
		}
		return fibonacciSequence;
	}

}
