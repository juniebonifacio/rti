/**
 * 
 */
package com.customer.rti.fps.logic;

import java.math.BigInteger;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.jaxb.util.FPSJAXBUtilImpl;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Body;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails.Keys;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header.MessageDetails;
import com.customer.rti.util.HttpClientUtil;

/**
 * @author developer
 *
 */

@Component
public class SubmissionPollImpl implements SubmissionPoll {

	@Autowired
	FPSJAXBUtilImpl fpsJAXBUtil;
	
	@Autowired
	HttpClientUtil httpClientUtil;
	
	@Override
	public String callSubmissionPoll(String strPollUrl, String strSubmissionAcknowledgement) {
		String strSubmissionPollResponse = null;
		boolean submissionNowProcessedByGatewayBackEnd = false;
		
		System.out.println("Step b. Get CorrelationID from SUBMISSION_ACKNOWLEDGEMENT (Doc Submission STEP 3) "
				+ "from Gateway (to be used in SUBMISSION_POLL).");
		
		GovTalkMessage submissionAcknowledgement = null;
		try {
			submissionAcknowledgement = fpsJAXBUtil.unmarshallXmlStringToBeanObject(strSubmissionAcknowledgement);
			
			String correlationID = null;
			if (null != submissionAcknowledgement && null != submissionAcknowledgement.getHeader()
					&& null != submissionAcknowledgement.getHeader().getMessageDetails()) {
				correlationID = submissionAcknowledgement.getHeader().getMessageDetails().getCorrelationID();
				System.out.println("correlationID: " + correlationID);
			}
			
			long pollIntervalLong = getPollInterval(submissionAcknowledgement);
						
			int i = 0;
			while(submissionNowProcessedByGatewayBackEnd != true) {
	//			System.out.println("Step c. Stop Thread. Wait for the number of seconds (period) "
	//			+ "specified under Poll Interval of GovTalk header of SUBMISSION_ACKNOWLEDGEMENT message.");
				sleep(pollIntervalLong);
				
				System.out.println("Building SUBMISSION_POLL REQUEST...");
				GovTalkMessage submissionPoll = new GovTalkMessage();
				submissionPoll.setEnvelopeVersion(submissionAcknowledgement.getEnvelopeVersion());
				Header header = new Header();
				MessageDetails messageDetails = new MessageDetails();
				messageDetails.setClazz(submissionAcknowledgement.getHeader().getMessageDetails().getClazz());
				messageDetails.setQualifier("poll");
				messageDetails.setFunction("submit");
				messageDetails.setCorrelationID(correlationID);
				messageDetails.setTransformation("XML");
				header.setMessageDetails(messageDetails);
				header.setSenderDetails(null);
				submissionPoll.setHeader(header);
				Body body = new Body();
				submissionPoll.setBody(body);
				GovTalkDetails govTalkDetails = new GovTalkDetails();
				Keys keys = new Keys();
				govTalkDetails.setKeys(keys);
				submissionPoll.setGovTalkDetails(govTalkDetails);
				
				String strSubmissionPoll = fpsJAXBUtil.marshallBeanObjectToXmlString(submissionPoll);

				System.out.println(" ========== Step 3. SUBMISSION_POLL ========== ");
				System.out.println("SUBMISSION_POLL REQUEST: " + strSubmissionPoll);
				strSubmissionPollResponse = httpClientUtil.callHttpPost(strPollUrl, strSubmissionPoll);
				System.out.println("SUBMISSION_POLL RESPONSE: " + strSubmissionPollResponse);
				submissionNowProcessedByGatewayBackEnd = checkQualifier(strSubmissionPollResponse);
				
//				System.out.println("Step d. Check the progress of the submission using SUBMISSION_POLL message.");
//				
//				System.out.println("Step f. If the gateway has not completed processing the message, it will reply with "
//						+ "another SUBMISSION_ACKNOWLEDGEMENT to indicate this to the client application.");
				
//				System.out.println("Step g. The client application (in this case Solutio) again waits for period "
//				+ "specified in the Poll Interval of the GovTalk header of SUBMISSION_ACKNOWLEDGEMENT message, "
//				+ "then checks the progress of the submission using the SUBMISSION_POLL message.");
//		
//				System.out.println("Step h. If the Gateway has now processed the message, it will reply with "
//				+ "a SUBMISSION_RESPONSE message to indicate the client application that it has finished "
//				+ "processing the document.");
				
				if(submissionNowProcessedByGatewayBackEnd == false) {
					submissionAcknowledgement = fpsJAXBUtil.unmarshallXmlStringToBeanObject(strSubmissionPollResponse);
					pollIntervalLong = getPollInterval(submissionAcknowledgement);
				}
				
				i++;
				System.out.println("Number of poll runs now: " + i);
			}
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		System.out.println("Returning SUBMISSION_POLL RESPONSE: " + strSubmissionPollResponse);
		return strSubmissionPollResponse;
	}

	private long getPollInterval(GovTalkMessage govTalkMessage) {
		long pollIntervalLong = 60000;
		System.out.println("Programmatically setting default pollIntervalLong: " + pollIntervalLong);
		
		if(null != govTalkMessage 
				&& null != govTalkMessage.getHeader() 
				&& null != govTalkMessage.getHeader().getMessageDetails() 
				&& null != govTalkMessage.getHeader().getMessageDetails().getResponseEndPoint()
				&& null != govTalkMessage.getHeader().getMessageDetails().getResponseEndPoint().getPollInterval()) {
			BigInteger pollInterval = govTalkMessage.getHeader().getMessageDetails().getResponseEndPoint().getPollInterval();
			System.out.println("Got pollInterval from SUBMISSION_ACKNOWLEDGEMENT: " + pollInterval);
			pollIntervalLong = pollInterval.longValue() * 1000;
			System.out.println("Multiply by 1000. Got pollIntervalLong from SUBMISSION_ACKNOWLEDGEMENT: " + pollIntervalLong);
		}

		return pollIntervalLong;
	}
	
	private void sleep(long sleepMilliSec) {
		
		System.out.println("Sleeping for " + sleepMilliSec + " milliseconds...");
		try {
			Thread.sleep(sleepMilliSec);
			System.out.println("Done sleeping for " + sleepMilliSec + " milliseconds...");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	private Boolean checkQualifier(String submissionPollResponse) throws JAXBException {
		Boolean submissionProcessedOnGatewayBackEnd = false;
		
		GovTalkMessage govTalkMessage = fpsJAXBUtil.unmarshallXmlStringToBeanObject(submissionPollResponse);
		if(null != govTalkMessage 
				&& null != govTalkMessage.getHeader() 
				&& null != govTalkMessage.getHeader().getMessageDetails() 
				&& null != govTalkMessage.getHeader().getMessageDetails()) {
				String qualifier = govTalkMessage.getHeader().getMessageDetails().getQualifier();
				String function = govTalkMessage.getHeader().getMessageDetails().getFunction();
				
				if(null != qualifier && "acknowledgement".equalsIgnoreCase(qualifier)
						&& null != function && "submit".equalsIgnoreCase(function)) {
					System.out.println("GETTING ACKNOWLEDGEMENT: qualifier: " + qualifier + "; function: " + function);
					submissionProcessedOnGatewayBackEnd = false;
				} else if (null != qualifier && "response".equalsIgnoreCase(qualifier)
						&& null != function && "submit".equalsIgnoreCase(function)) {
					System.out.println("NOW PROCESSED BY GATEWAY BACK-END:qualifier: " + qualifier + "; function: " + function);
					submissionProcessedOnGatewayBackEnd = true;
				}
				
		}
		System.out.println("checkQualifier: Returning " + submissionProcessedOnGatewayBackEnd);
		return submissionProcessedOnGatewayBackEnd;
	}
	
}
