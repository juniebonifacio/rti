/**
 * 
 */
package com.customer.rti.fps.util;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Address;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Name;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class EmployeeDetailsUtilImpl implements EmployeeDetailsUtil {

	@Override
	public EmployeeDetails createEmployeeDetails(String strNINO, Name name,
			Address address, Date birthDate, String strGender) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Name createName(String strTitle, String strSurname, String ... foreName) {
		Name name = new Name();
		name.setTtl(strTitle);
		name.setSur(strSurname);
		List<String> fore = name.getFore();
		
		for (int i = 0; i < foreName.length; i++) {
			String strForeName = foreName[i];
			fore.add(strForeName);
		}
		
		return name;
	}
	
	public Address createAddress(String strUKPostCode, String ... addressLines) {
		
		Address address = new Address();
		address.setUKPostcode(strUKPostCode);
		
		List<String> lines = address.getLine();
		
		for (int i = 0; i < addressLines.length; i++) {
			String strAddressLine = addressLines[i];
			lines.add(strAddressLine);
		}
		
		return address;
	}

	
}
