/**
 * 
 */
package com.customer.rti.fps.excel;

import java.util.Date;

import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmissionISOcurrencyType;
import com.customer.rti.rim2016.v1_2.fps.generated.IRheader.IRmark;

/**
 * @author junie.bonifacio
 *
 */
public interface FPSExcelToGovTalkMsgConverter {

	public GovTalkMessage convertExcelToFPSMessage(String strEnvelopeVersion, String strClass, String strTransactionID,
			String strSenderID, String strAuthMethod, String strAuthRole, String strAuthValue, String strEmailAddress,
			String strTaxOfficeNumber, String strTaxOfficeReference, String strOrganization,
			String strChannelURI, String strChannelProduct, String strChannelVersion, 
			Date timeStamp, Date periodEnd, FullPaymentSubmissionISOcurrencyType defaultCurrency, IRmark irMark, String strSender,
			FullPaymentSubmission fullPaymentSubmission) throws Exception;
}
