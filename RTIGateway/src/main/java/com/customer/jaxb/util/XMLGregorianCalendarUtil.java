/**
 * 
 */
package com.customer.jaxb.util;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author junie.bonifacio
 *
 */
public interface XMLGregorianCalendarUtil {

	public XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException;
	
}
