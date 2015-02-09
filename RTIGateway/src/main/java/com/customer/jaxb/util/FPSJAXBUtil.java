/**
 * 
 */
package com.customer.jaxb.util;

import javax.xml.bind.JAXBException;

import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;

/**
 * @author junie.bonifacio
 *
 */
public interface FPSJAXBUtil {

	public String marshallBeanObjectToXmlString(GovTalkMessage govTalkMessage) throws JAXBException;
	
	public GovTalkMessage unmarshallXmlStringToBeanObject(String xmlString) throws JAXBException;
	
}
