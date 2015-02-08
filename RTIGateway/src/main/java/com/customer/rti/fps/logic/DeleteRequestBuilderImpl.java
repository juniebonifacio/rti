/**
 * 
 */
package com.customer.rti.fps.logic;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.rti.fps.util.FPSJAXBUtilImpl;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Body;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails.Keys;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header.MessageDetails;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class DeleteRequestBuilderImpl implements DeleteRequestBuilder {

	@Autowired
	FPSJAXBUtilImpl fpsJAXBUtil;
	
	@Override
	public String buildDeleteRequest(String pollResponse) throws JAXBException {
		String strDeleteRequest = null;
		
		GovTalkMessage pollResponseObj = fpsJAXBUtil.unmarshallXmlStringToBeanObject(pollResponse);
		String strEnvelopeVersion = pollResponseObj.getEnvelopeVersion();
		String strClass = pollResponseObj.getHeader().getMessageDetails().getClazz();
		String strTransactionID = pollResponseObj.getHeader().getMessageDetails().getTransactionID();
		String strCorrelationID = pollResponseObj.getHeader().getMessageDetails().getCorrelationID();
		
		GovTalkMessage govTalkMessage = new GovTalkMessage();
		govTalkMessage.setEnvelopeVersion(strEnvelopeVersion);
		Header header = new Header();
		MessageDetails messageDetails = new MessageDetails();
		messageDetails.setClazz(strClass);
		messageDetails.setQualifier("request");
		messageDetails.setFunction("delete");
		messageDetails.setTransactionID(strTransactionID);
		messageDetails.setCorrelationID(strCorrelationID);
		messageDetails.setTransformation("XML");
		header.setMessageDetails(messageDetails);
		govTalkMessage.setHeader(header);
		GovTalkDetails govTalkDetails = new GovTalkDetails();
		Keys keys = new Keys();
		govTalkDetails.setKeys(keys);
		govTalkMessage.setGovTalkDetails(govTalkDetails);
		Body body = new Body();
		govTalkMessage.setBody(body);
		
		
		strDeleteRequest = fpsJAXBUtil.marshallBeanObjectToXmlString(govTalkMessage);
		
		return strDeleteRequest;
	}

	
	
}
