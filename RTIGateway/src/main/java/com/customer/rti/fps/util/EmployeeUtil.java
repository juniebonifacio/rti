/**
 * 
 */
package com.customer.rti.fps.util;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Address;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Name;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment;

/**
 * @author junie.bonifacio
 *
 */
public interface EmployeeUtil {

	public com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee createEmployee(String strNINO, 
			Name name, Address address, Date birthDate, String strGender,
			List<Employment> employment) throws DatatypeConfigurationException;
	
}
