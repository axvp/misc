/**
 * 
 */
package com.jeeatwork.java.examples.junit.failfast;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for the {@link FailFastListener}.
 * 
 * @author tom1299
 *
 */
@RunWith(FailFastTestRunner.class)
public class FailFastListenerTest {

	private static int TESTSRUN = 0;

	@Test
	public void testA() {
		this.testMethod();
	}

	@Test
	public void testB() {
		this.testMethod();
	}

	@Test
	public void testC() {
		this.testMethod();
	}

	private void testMethod() {
		TESTSRUN++;
		this.throwExceptionOnSecondTest();
		this.failOnThirdTest();
	}

	private void throwExceptionOnSecondTest() {
		if (TESTSRUN == 2) {
			throw new RuntimeException("Second test throws exception");
		}
	}

	private void failOnThirdTest() {
		if (TESTSRUN == 3) {
			fail("Third test should never have been executed");
		}
	}
}
