/**
 * 
 */
package com.customer.rti.fps.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.rti.util.HttpClientUtil;


/**
 * @author junie.bonifacio
 *
 */
@SuppressWarnings("deprecation")
@Component
public class SubmissionRequestImpl implements SubmissionRequest {

	@Autowired
	HttpClientUtil httpClientUtil;
	
	@Override
	public String callSubmissionRequest(String strSubmissionUrl, String xmlGovTalkMessage) {
		String submissionAcknowledgement = httpClientUtil.callHttpPost(strSubmissionUrl, xmlGovTalkMessage);
		return submissionAcknowledgement;
	}

}