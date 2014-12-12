/**
 * 
 */
package de.telekom.pd.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author reuhl
 *
 */
@XmlRootElement
public class FibonacciSequence {
	
	List<Long> sequence;

	/**
	 * 
	 */
	public FibonacciSequence() {
		super();
	}

	/**
	 * @return the sequence
	 */
	public List<Long> getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	@XmlElement
	public void setSequence(List<Long> sequence) {
		this.sequence = sequence;
	}

}
