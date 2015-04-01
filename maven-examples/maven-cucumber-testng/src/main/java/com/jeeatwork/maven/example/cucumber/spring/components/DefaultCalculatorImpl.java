/**
 * 
 */
package com.jeeatwork.maven.example.cucumber.spring.components;

import com.jeeatwork.maven.example.cucumber.spring.Calculator;

/**
 * @author tom1299
 *
 */
public class DefaultCalculatorImpl implements Calculator {
	
	private int waitPeriod = 0;

	/**
	 * 
	 */
	public DefaultCalculatorImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.jeeatwork.maven.example.cucumber.spring.Calculator#add(long, long)
	 */
	public long add(long n1, long n2) {
		try {
			Thread.sleep(waitPeriod * 1000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return n1 + n2;
	}

	public int getWaitPeriod() {
		return waitPeriod;
	}

	public void setWaitPeriod(int waitPeriod) {
		this.waitPeriod = waitPeriod;
	}

}
