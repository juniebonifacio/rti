/**
 * 
 */
package com.customer.rti.fps.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class EmploymentUtilImpl implements EmploymentUtil {

	@Override
	public List<com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment> createEmployment(
			com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment ... employment) {
		
		List<com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment> employmentList
		= new ArrayList<com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment>();
		
		for (int i = 0; i < employment.length; i++) {
			com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment
			employmentObj = employment[i];
			employmentList.add(employmentObj);
		}
		
		return employmentList;
		
	}

}
