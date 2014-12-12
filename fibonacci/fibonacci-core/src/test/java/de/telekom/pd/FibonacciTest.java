package de.telekom.pd;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testCalculateSequence() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		Long[] sequence = fibonacci.calculateSequence(10);
		
		assertEquals(10, sequence.length);
		assertArrayEquals(new Long[]{0l,1l,1l,2l,3l,5l,8l,13l,21l,34l}, sequence);
	}
	
	@Test
	public void testCalculateSequenceWith0() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		Long[] sequence = fibonacci.calculateSequence(0);
		
		assertEquals(0, sequence.length);
		assertArrayEquals(new Long[]{}, sequence);
	}
	
	@Test
	public void testCalculateSequenceWithNegativeLength() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		Long[] sequence = fibonacci.calculateSequence(-1);
		
		assertEquals(0, sequence.length);
		assertArrayEquals(new Long[]{}, sequence);
	}

}
