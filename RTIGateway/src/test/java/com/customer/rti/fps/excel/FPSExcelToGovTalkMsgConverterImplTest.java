package com.customer.rti.fps.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.jaxb.util.FPSJAXBUtilImpl;
import com.customer.rti.fps.excel.FPSExcelToGovTalkMsgConverter;
import com.customer.rti.fps.util.EmployeeDetailsUtil;
import com.customer.rti.fps.util.EmployeeUtil;
import com.customer.rti.fps.util.FullPaymentSubmissionUtil;
import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.EmpRefs;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Address;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.EmployeeDetails.Name;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmission.Employee.Employment;
import com.customer.rti.rim2016.v1_2.fps.generated.FullPaymentSubmissionISOcurrencyType;
import com.customer.rti.rim2016.v1_2.fps.generated.IRheader.IRmark;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class FPSExcelToGovTalkMsgConverterImplTest {
	
	@Autowired
	FPSExcelToGovTalkMsgConverter converter;
	
	@Autowired
	FPSJAXBUtilImpl fpsJAXBUtil;
	
	@Autowired
	com.customer.jaxb.util.XMLGregorianCalendarUtil xmlGregorianCalendarUtil;
	
	@Autowired
	EmployeeDetailsUtil employeeDetailsUtil;
	
	@Autowired
	FullPaymentSubmissionUtil fullPaymentSubmissionUtil;
	
	@Autowired
	EmployeeUtil employeeUtil;
	
	@Test
	public void test() throws Exception {
		
		String strEnvelopeVersion = "2.0";
		String strClass = "HMRC-PAYE-RTI-FPS";
		String strTransactionID = "20021202ABC";
		String strSenderID = "ISV958";
		String strAuthMethod = "clear";
		String strAuthRole = "principal";
		String strAuthValue = "testing1";
		String strEmailAddress = "junie.bonifacio@customer.com";
		String strTaxOfficeNumber = "958";
		String strTaxOfficeReference = "A958";
		String strOrganization = "IR";
		String strChannelURI = "https://portal.solutio.com";
		String strChannelProduct = "Solutio";
		String strChannelVersion = "1.0.0";
		Date timeStamp = new Date();
		Date periodEnd = new Date();
		FullPaymentSubmissionISOcurrencyType defaultCurrency = FullPaymentSubmissionISOcurrencyType.GBP;
		IRmark irMark = new IRmark();
		String irMarkType = "generic";
		irMark.setType(irMarkType);
		String irMarkValue = "/Qal//2vd1J+iIAMc91uY4OjpUU=";
		irMark.setValue(irMarkValue);
		String strSender = "Employer";
		
		//EmpRefs
		EmpRefs empRefs = new EmpRefs();
		empRefs.setOfficeNo("958");
		empRefs.setPayeRef("A958");
		empRefs.setAORef("635PC00000000");
		empRefs.setECON("E3567891A");
		empRefs.setCOTAXRef("1111111111");
		
		//Related Tax Year
		String strRelatedTaxYear = "15-16";
		
		//Name
		String strTitle = "Mr";
		String strSurname = "Surname";
		String foreName[] = {"John", "Edward"};
		Name name = employeeDetailsUtil.createName(strTitle, strSurname, foreName);
		
		String strNINO = "AB164231A";
		Address address = new Address();
		Date birthDate = new Date();
		String strGender = "M";
		List<Employment> employment = new ArrayList<Employment>();
		employment.add(new Employment());

		Employee employee1 = employeeUtil.createEmployee(strNINO, name, address, birthDate, strGender, employment);
		
		FullPaymentSubmission fullPaymentSubmission = fullPaymentSubmissionUtil.createFullPaymentSubmission(empRefs, strRelatedTaxYear, employee1);
		
		GovTalkMessage govTalkMessage = converter.convertExcelToFPSMessage(strEnvelopeVersion, strClass, strTransactionID, strSenderID, 
				strAuthMethod, strAuthRole, strAuthValue, strEmailAddress,
				strTaxOfficeNumber, strTaxOfficeReference, strOrganization, strChannelURI, strChannelProduct, strChannelVersion,
				timeStamp, periodEnd, defaultCurrency, irMark, strSender, fullPaymentSubmission);
		
		
		String strGovTalkMessage = fpsJAXBUtil.marshallBeanObjectToXmlString(govTalkMessage);
		System.out.println("strGovTalkMessage: " + strGovTalkMessage);
		
		
		
	}

}
