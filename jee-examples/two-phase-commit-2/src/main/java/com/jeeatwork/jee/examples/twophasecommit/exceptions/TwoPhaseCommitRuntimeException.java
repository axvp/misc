/**
 * 
 */
package com.jeeatwork.jee.examples.twophasecommit.exceptions;

/**
 * @author reuhl
 *
 */
public class TwoPhaseCommitRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7829897932853661664L;

	/**
	 * 
	 */
	public TwoPhaseCommitRuntimeException() {
		super();
	}

	/**
	 * @param message
	 */
	public TwoPhaseCommitRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TwoPhaseCommitRuntimeException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TwoPhaseCommitRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public TwoPhaseCommitRuntimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
