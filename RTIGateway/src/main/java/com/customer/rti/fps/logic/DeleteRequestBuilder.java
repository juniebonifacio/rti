/**
 * 
 */
package com.customer.rti.fps.logic;

import javax.xml.bind.JAXBException;

/**
 * @author junie.bonifacio
 *
 */
public interface DeleteRequestBuilder {

	public String buildDeleteRequest(String pollResponse) throws JAXBException;
	
}
