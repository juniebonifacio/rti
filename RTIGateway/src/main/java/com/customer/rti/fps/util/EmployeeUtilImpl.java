/**
 * 
 */
package com.customer.rti.fps.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Address;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Name;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class EmployeeUtilImpl implements EmployeeUtil {

	@Override
	public com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee createEmployee(String strNINO, 
			Name name, Address address, Date birthDate, String strGender,
			List<com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment> employmentFromFps) throws DatatypeConfigurationException {
		com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee employee =
				new com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee();
		
		EmployeeDetails employeeDetails = new EmployeeDetails();
		if(null != strNINO && !"".equalsIgnoreCase(strNINO)) {
			employeeDetails.setNINO(strNINO);			
		}
		employeeDetails.setName(name);
		employeeDetails.setAddress(address);
		GregorianCalendar birthDateGregorianCalendar = new GregorianCalendar();
		birthDateGregorianCalendar.setTime(birthDate);
		//Set the Current Date to the XMLGregorianCalendar
		XMLGregorianCalendar birthDateXMLCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(birthDateGregorianCalendar);
		employeeDetails.setBirthDate(birthDateXMLCalendar);
		employeeDetails.setGender(strGender);
		employee.setEmployeeDetails(employeeDetails);

		List<com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment> 
		employment = employee.getEmployment();
		
		for (int i = 0; i < employmentFromFps.size(); i++) {
			com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment
			employmentObj = employmentFromFps.get(i);
			employment.add(employmentObj);
		}

		return employee;
		
	}

}
