/**
 * 
 */
package com.customer.rti.fps.logic;

import javax.xml.bind.JAXBException;

/**
 * @author junie.bonifacio
 *
 */
public interface DeleteRequest {

	public String callDeleteRequest(String strSubmissionUrl, String xmlGovTalkMessage) throws JAXBException;
}
