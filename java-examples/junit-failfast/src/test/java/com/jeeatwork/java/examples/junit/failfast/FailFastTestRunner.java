package com.jeeatwork.java.examples.junit.failfast;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * A test runner that use the {@link FailFastListener} to fail test suite
 * immediately after the first failure.
 * 
 * @author tom1299
 *
 */
public class FailFastTestRunner extends BlockJUnit4ClassRunner {

	/**
	 * Overriden constructor
	 * 
	 * @param klass The test class
	 * @throws InitializationError In case test initialization fails.
	 */
	public FailFastTestRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	/* (non-Javadoc)
	 * @see org.junit.runners.ParentRunner#run(org.junit.runner.notification.RunNotifier)
	 */
	@Override
	public void run(RunNotifier notifier) {
		notifier.addListener(new FailFastListener(notifier));
		super.run(notifier);
	}

}
