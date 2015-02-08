package com.customer.rti.fps.excel;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.rti.fps.util.FPSJAXBUtilImpl;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmissionISOcurrencyType;
import com.customer.rti.rim2016.v1_2.fps.generated.IRheader.IRmark;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class FPSExcelToGovTalkMsgConverterImplTest {

	@Autowired
	FPSExcelToGovTalkMsgConverter converter;
	
	@Autowired
	FPSJAXBUtilImpl fpsJAXBUtil;
	
	@Test
	public void test() throws Exception {

		
		String strEnvelopeVersion = "2.0";
		String strClass = "HMRC-PAYE-RTI-FPS";
		String strTransactionID = "20021202ABC";
		String strSenderID = "ISV958";
		String strAuthMethod = "clear";
		String strAuthRole = "principal";
		String strAuthValue = "testing1";
		String strEmailAddress = "junie.bonifacio@customer.com";
		String strTaxOfficeNumber = "958";
		String strTaxOfficeReference = "A958";
		String strOrganization = "IR";
		String strChannelURI = "https://portal.solutio.com";
		String strChannelProduct = "Solutio";
		String strChannelVersion = "1.0.0";
		Date timeStamp = new Date();
		Date periodEnd = new Date();
		FullPaymentSubmissionISOcurrencyType defaultCurrency = FullPaymentSubmissionISOcurrencyType.GBP;
		IRmark irMark = new IRmark();
		
		GovTalkMessage govTalkMessage = converter.convertExcelToFPSMessage(strEnvelopeVersion, strClass, strTransactionID, strSenderID, 
				strAuthMethod, strAuthRole, strAuthValue, strEmailAddress,
				strTaxOfficeNumber, strTaxOfficeReference, strOrganization, strChannelURI, strChannelProduct, strChannelVersion,
				timeStamp, periodEnd, defaultCurrency, irMark);
		
		
		String strGovTalkMessage = fpsJAXBUtil.marshallBeanObjectToXmlString(govTalkMessage);
		System.out.println("strGovTalkMessage: " + strGovTalkMessage);
		
		
		
	}

}
