/**
 * 
 */
package com.jeeatwork.java.examples.junit.failfast;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

/**
 * @author tom1299
 * 
 * A very basic class, that listens for junit test failures and immediately
 * fails the whole suite on the first failure: "fail fast"
 */
public class FailFastListener extends RunListener {
	
	private RunNotifier runNotifier;

	/**
	 * Default, empty constructor
	 */
	public FailFastListener(RunNotifier runNotifier) {
		super();
		this.runNotifier = runNotifier;
	}

	/**
	 * Throws an exception to terminate the whole test run, on the first failure
	 */
	@Override
	public void testFailure(Failure failure) throws Exception {
		this.runNotifier.pleaseStop();
	}
}