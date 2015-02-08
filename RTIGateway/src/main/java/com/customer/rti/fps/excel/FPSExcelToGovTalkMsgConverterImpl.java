/**
 * 
 */
package com.customer.rti.fps.excel;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Body;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails.ChannelRouting;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails.ChannelRouting.Channel;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails.Keys.Key;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails.TargetDetails;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header.MessageDetails;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header.SenderDetails;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header.SenderDetails.IDAuthentication;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.Header.SenderDetails.IDAuthentication.Authentication;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmissionISOcurrencyType;
import com.customer.rti.rim2016.v1_2.fps.generated.IRenvelope;
import com.customer.rti.rim2016.v1_2.fps.generated.IRheader;
import com.customer.rti.rim2016.v1_2.fps.generated.IRheader.IRmark;


/**
 * @author junie.bonifacio
 *
 */
@Component
public class FPSExcelToGovTalkMsgConverterImpl implements
		FPSExcelToGovTalkMsgConverter {

	private static final Logger logger = Logger.getLogger(FPSExcelToGovTalkMsgConverterImpl.class);
	
	public GovTalkMessage convertExcelToFPSMessage(String strEnvelopeVersion, String strClass, String strTransactionID,
			String strSenderID, String strAuthMethod, String strAuthRole, String strAuthValue, String strEmailAddress,
			String strTaxOfficeNumber, String strTaxOfficeReference, String strOrganization,
			String strChannelURI, String strChannelProduct, String strChannelVersion,
			Date timeStamp, Date periodEnd, FullPaymentSubmissionISOcurrencyType defaultCurrency, IRmark irMark) throws Exception {
	
		if(null == strEnvelopeVersion || "".equalsIgnoreCase(strEnvelopeVersion)) {
			throw new Exception("strEnvelopeVersion is null or empty string...");
		}
		if(null == strClass || "".equalsIgnoreCase(strClass)) {
			throw new Exception("strClass is null or empty string...");
		}
		if(null == strTransactionID || "".equalsIgnoreCase(strTransactionID)) {
			throw new Exception("strTransactionID is null or empty string...");
		}
		if(null == strSenderID || "".equalsIgnoreCase(strSenderID)) {
			throw new Exception("strSenderID is null or empty string...");
		}
		if(null == strAuthMethod || "".equalsIgnoreCase(strAuthMethod)) {
			throw new Exception("strAuthMethod is null or empty string...");
		}
		if(null == strAuthRole || "".equalsIgnoreCase(strAuthRole)) {
			throw new Exception("strAuthRole is null or empty string...");
		}
		if(null == strAuthValue || "".equalsIgnoreCase(strAuthValue)) {
			throw new Exception("strAuthValue is null or empty string...");
		}
		if(null == strTaxOfficeNumber || "".equalsIgnoreCase(strTaxOfficeNumber)) {
			throw new Exception("strTaxOfficeNumber is null or empty string...");
		}
		if(null == strTaxOfficeReference || "".equalsIgnoreCase(strTaxOfficeReference)) {
			throw new Exception("strTaxOfficeReference is null or empty string...");
		}
		if(null == strOrganization || "".equalsIgnoreCase(strOrganization)) {
			throw new Exception("strTaxOfficeReference is null or empty string...");
		}
		if(null == strChannelURI || "".equalsIgnoreCase(strChannelURI)) {
			throw new Exception("strChannelURI is null or empty string...");
		}
		if(null == strChannelProduct || "".equalsIgnoreCase(strChannelProduct)) {
			throw new Exception("strChannelProduct is null or empty string...");
		}
		if(null == strChannelVersion || "".equalsIgnoreCase(strChannelVersion)) {
			throw new Exception("strChannelVersion is null or empty string...");
		}
		if(null == timeStamp) {
			throw new Exception("timeStamp is null...");
		}
		
		
		GovTalkMessage govTalkMessage = new GovTalkMessage();
		govTalkMessage.setEnvelopeVersion(strEnvelopeVersion);
		Header header = new Header();
		//MessageDetails
		MessageDetails messageDetails = new MessageDetails();
		logger.debug("Class - Mandatory. The class of XML document contained in the body.");
		messageDetails.setClazz(strClass);
		logger.debug("Qualifier - Mandatory. Set to 'request'.");
		messageDetails.setTransactionID(strTransactionID);
		messageDetails.setQualifier("request");
		logger.debug("Function - Mandatory. Set to 'submit'.");
		messageDetails.setFunction("submit");
		logger.debug("CorrelationID - Mandatory. Element must be empty.");
		messageDetails.setCorrelationID("");
		messageDetails.setTransformation("XML");	
		header.setMessageDetails(messageDetails);
		//SenderDetails
		SenderDetails senderDetails = new SenderDetails();
		IDAuthentication idAuthentication = new IDAuthentication();
		idAuthentication.setSenderID(strSenderID);
		Authentication authentication = new Authentication();
		authentication.setMethod(strAuthMethod);
		authentication.setRole(strAuthRole);
		authentication.setValue(strAuthValue);
		idAuthentication.getAuthentication().add(authentication);
		senderDetails.setEmailAddress(strEmailAddress);
		senderDetails.setIDAuthentication(idAuthentication);
		header.setSenderDetails(senderDetails);
		govTalkMessage.setHeader(header);
		
		//GovTalkDetails
		GovTalkDetails govTalkDetails = new GovTalkDetails();
		//Keys
		com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails.Keys govTalkDetailsKeys 
		= new com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage.GovTalkDetails.Keys();
		Key taxOfficeNumber = new Key();
		taxOfficeNumber.setType("TaxOfficeNumber");
		taxOfficeNumber.setValue(strTaxOfficeNumber);
		govTalkDetailsKeys.getKey().add(taxOfficeNumber);
		Key taxOfficeReference = new Key();
		taxOfficeReference.setType("TaxOfficeReference");
		taxOfficeReference.setValue(strTaxOfficeReference);
		govTalkDetailsKeys.getKey().add(taxOfficeReference);
		govTalkDetails.setKeys(govTalkDetailsKeys);
		//TargetDetails
		TargetDetails targetDetails = new TargetDetails();
		targetDetails.getOrganisation().add(strOrganization);
		//ChannelRouting
		ChannelRouting channelRouting = new ChannelRouting();
		Channel channel = new Channel();
		channel.setURI(strChannelURI);
		channel.setProduct(strChannelProduct);
		channel.setVersion(strChannelVersion);
		channelRouting.setChannel(channel);
		
		//Get Current Date
		GregorianCalendar timeStampGregorianCalendar = new GregorianCalendar();
		logger.debug("TODO: refactor dateToday to be called outside");
		timeStampGregorianCalendar.setTime(timeStamp);
		//Set the Current Date to the XMLGregorianCalendar
		XMLGregorianCalendar timeStampXMLCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(timeStampGregorianCalendar);
		channelRouting.setTimestamp(timeStampXMLCalendar);

		govTalkDetails.getChannelRouting().add(channelRouting);
		govTalkDetails.setTargetDetails(targetDetails);
		govTalkMessage.setGovTalkDetails(govTalkDetails);
		
		//Body
		Body body = new Body();
		IRenvelope irEnvelope = new IRenvelope();
		IRheader irHeader = new IRheader();
		com.customer.rti.rim2016.v1_2.fps.generated.IRheader.Keys irHeaderKeys 
		= new com.customer.rti.rim2016.v1_2.fps.generated.IRheader.Keys();
		com.customer.rti.rim2016.v1_2.fps.generated.IRheader.Keys.Key taxOfficeNumberKey
		= new com.customer.rti.rim2016.v1_2.fps.generated.IRheader.Keys.Key();
		taxOfficeNumberKey.setType("TaxOfficeNumber");
		taxOfficeNumberKey.setValue(strTaxOfficeNumber);
		irHeaderKeys.getKey().add(taxOfficeNumberKey);
		com.customer.rti.rim2016.v1_2.fps.generated.IRheader.Keys.Key taxOfficeReferenceKey
		= new com.customer.rti.rim2016.v1_2.fps.generated.IRheader.Keys.Key();
		taxOfficeReferenceKey.setType("TaxOfficeReference");
		taxOfficeReferenceKey.setValue(strTaxOfficeReference);
		irHeaderKeys.getKey().add(taxOfficeReferenceKey);
		irHeader.setKeys(irHeaderKeys);
		GregorianCalendar periodEndGregorianCalendar = new GregorianCalendar();
		periodEndGregorianCalendar.setTime(periodEnd);
		XMLGregorianCalendar periodEndXMLCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(periodEndGregorianCalendar);
		irHeader.setPeriodEnd(periodEndXMLCalendar);
		irHeader.setDefaultCurrency(defaultCurrency);
		irHeader.setIRmark(irMark);
		irEnvelope.setIRheader(irHeader);
		body.getAny().add(irEnvelope);
		govTalkMessage.setBody(body);
		
		return govTalkMessage;
	}
	
}
