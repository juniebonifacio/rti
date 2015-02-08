/**
 * 
 */
package com.customer.rti.fps.logic;

import javax.xml.bind.JAXBException;

/**
 * @author junie.bonifacio
 *
 */
public interface FPSGatewayService {

	public String callSubmitFPS(String strSubmissionUrl, String strPollUrl, String strFPSFilePath) throws JAXBException;
	public String callSubmissionRequest(String strSubmissionUrl, String strFPSFilePath);
	public String callSubmissionPoll(String strPollUrl, String request);
	public String callDeleteRequest(String strSubmissionUrl, String request) throws JAXBException;
	
}
