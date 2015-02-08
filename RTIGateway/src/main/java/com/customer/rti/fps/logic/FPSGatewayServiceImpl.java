/**
 * 
 */
package com.customer.rti.fps.logic;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class FPSGatewayServiceImpl implements FPSGatewayService {

	@Autowired
	private SubmissionRequest submissionRequest;
	
	@Autowired
	private SubmissionPoll submissionPoll;
	
	@Autowired
	private DeleteRequest deleteRequest;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.customer.rti.fps.logic.FPSGatewaySubmitter#callSubmitFPS(java
	 * .lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String callSubmitFPS(String strSubmissionUrl, String strPollUrl,
			String strFPSFilePath) throws JAXBException {
		
		String strSubmissionAck = callSubmissionRequest(strSubmissionUrl, strFPSFilePath);

		String strPollResponse = callSubmissionPoll(strPollUrl, strSubmissionAck);
		
		String strDeleteResponse = callDeleteRequest(strSubmissionUrl, strPollResponse);
		
		return strDeleteResponse;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.customer.rti.fps.logic.FPSGatewaySubmitter#callSubmissionRequest(java
	 * .lang.String)
	 */
	@Override
	public String callSubmissionRequest(String strSubmissionUrl,
			String strFPSFilePath) {
		System.out.println("Start callSubmissionRequest...");

		String strSubmissionAck = submissionRequest.callSubmissionRequest(
				strSubmissionUrl, strFPSFilePath);
		
		System.out.println("Done callSubmissionRequest...");
		return strSubmissionAck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.customer.rti.fps.logic.FPSGatewaySubmitter#callSubmissionPoll(java
	 * .lang.String)
	 */
	@Override
	public String callSubmissionPoll(String strPollUrl, String strGovTalkMessage) {
		System.out.println("Start callSubmissionPoll...");

		System.out.println("strPollUrl: " + strPollUrl);
		System.out.println("strGovTalkMessage: " + strGovTalkMessage);
		
		String strPollResponse = submissionPoll.callSubmissionPoll(strPollUrl, strGovTalkMessage);
		
		System.out.println("Done callSubmissionPoll...");
		return strPollResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.customer.rti.fps.logic.FPSGatewaySubmitter#callDeleteRequest(java.
	 * lang.String)
	 */
	@Override
	public String callDeleteRequest(String strSubmissionUrl, String strGovTalkMessage) throws JAXBException {
		System.out.println("Start callDeleteRequest...");
		
		String strDeleteResponse = deleteRequest.callDeleteRequest(strSubmissionUrl, strGovTalkMessage);
		
		System.out.println("Done callDeleteRequest...");
		return strDeleteResponse;
	}

}
