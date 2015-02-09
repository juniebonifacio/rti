/**
 * 
 */
package com.customer.rti.fps.util;

import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.EmpRefs;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee;

/**
 * @author junie.bonifacio
 *
 */
public interface FullPaymentSubmissionUtil {

	public FullPaymentSubmission createFullPaymentSubmission(EmpRefs empRefs, String strRelatedTaxYear, Employee ... employees);
}
