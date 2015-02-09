/**
 * 
 */
package com.customer.rti.fps.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.EmpRefs;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class FullPaymentSubmissionUtilImpl implements FullPaymentSubmissionUtil {
	
	@Override
	public FullPaymentSubmission createFullPaymentSubmission(EmpRefs empRefs,
			String strRelatedTaxYear, Employee... employees) {
		
		FullPaymentSubmission fullPaymentSubmission = new FullPaymentSubmission();
		fullPaymentSubmission.setEmpRefs(empRefs);
		fullPaymentSubmission.setRelatedTaxYear(strRelatedTaxYear);
		
		List<Employee> employee = fullPaymentSubmission.getEmployee();
		
		if(null != employees) {
			for (int i = 0; i < employees.length; i++) {
				Employee e = employees[i];
				employee.add(e);
			}
		}
		
		return fullPaymentSubmission;
	}

}
