package com.customer.jaxb.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;
import com.customer.rti.rim2016.v1_2.fps.generated.IRenvelope;

@Component
public class FPSJAXBUtilImpl implements FPSJAXBUtil {

	private static final Logger logger = Logger.getLogger(FPSJAXBUtilImpl.class);
	
	public String marshallBeanObjectToXmlString(GovTalkMessage govTalkMessage) throws JAXBException {
		String strGovTalkMessage = null;
		
		JAXBContext context = JAXBContext.newInstance(GovTalkMessage.class, IRenvelope.class);
		
	    Marshaller marshaller = context.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    
	    StringWriter stringWriter = new StringWriter();
		marshaller.marshal(govTalkMessage, stringWriter);
		
		strGovTalkMessage = stringWriter.toString();
		//logger.debug("strGovTalkMessage: \n" + strGovTalkMessage);
		
		return strGovTalkMessage;
		
	}
	
	public GovTalkMessage unmarshallXmlStringToBeanObject(String xmlString) throws JAXBException {
		
		System.out.println("Create JAXBContext which will be used to create a Binder...");
		JAXBContext jaxbContext = JAXBContext.newInstance(GovTalkMessage.class, IRenvelope.class);
		
		Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();
		
		System.out.println("Unmarshall xml data to java content tree...");
		StreamSource streamSource = new StreamSource(new StringReader(xmlString));
		JAXBElement<GovTalkMessage> jaxbElement = unmarshaller.unmarshal(streamSource, GovTalkMessage.class);

		GovTalkMessage govTalkMessage = (GovTalkMessage) jaxbElement.getValue();

		return govTalkMessage;
	}
	
}
