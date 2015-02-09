/**
 * 
 */
package com.customer.jaxb.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class XMLGregorianCalendarUtilImpl implements XMLGregorianCalendarUtil {

	public XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		
		return xmlGregorianCalendar;
		
	}
	
}
