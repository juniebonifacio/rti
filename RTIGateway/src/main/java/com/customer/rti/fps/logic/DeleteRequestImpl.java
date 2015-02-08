/**
 * 
 */
package com.customer.rti.fps.logic;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.rti.util.HttpClientUtil;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class DeleteRequestImpl implements DeleteRequest {

	@Autowired
	HttpClientUtil httpClientUtil;
	
	@Autowired
	DeleteRequestBuilder deleteRequestBuilder;
	
	@Override
	public String callDeleteRequest(String strSubmissionUrl, String strPollResponse) throws JAXBException {
		System.out.println("=========== Start callDeleteRequest...");
		System.out.println("=========== strPollResponse: " + strPollResponse);
		
		String strDeleteRequest = deleteRequestBuilder.buildDeleteRequest(strPollResponse);

		String strDeleteResponse = httpClientUtil.callHttpPost(strSubmissionUrl, strDeleteRequest);
		System.out.println("strDeleteResponse: " + strDeleteResponse);
		
		System.out.println("=========== Done callDeleteRequest...");		
		return strDeleteResponse;
	}
	
}
