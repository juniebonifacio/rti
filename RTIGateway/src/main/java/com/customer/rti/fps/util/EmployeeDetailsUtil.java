/**
 * 
 */
package com.customer.rti.fps.util;

import java.util.Date;

import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Address;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Name;

/**
 * @author junie.bonifacio
 *
 */
public interface EmployeeDetailsUtil {

	public EmployeeDetails createEmployeeDetails(String strNINO, Name name, Address address, Date birthDate, String strGender);
	
	public Name createName(String strTitle, String strSurname, String ... foreName);
	
	public Address createAddress(String strUKPostCode, String ... addressLines);
	
}
