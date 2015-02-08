package com.customer.rti.fps.logic;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.rti.fps.logic.DeleteRequestBuilder;
import com.customer.rti.util.Util;


@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class DeleteRequestBuilderImplTest {

	@Autowired
	DeleteRequestBuilder deleteRequestBuilder;
	
	@Test
	public void testBuildDeleteRequest() throws JAXBException {
		
		String pathname = "/home/developer/rti-workspace/RTIGateway/samples_output_from_gov/06_SUBMISSION_RESPONSE.xml";
		pathname = Util.replaceWhiteSpaces(pathname);

		String strPollResponse = "";
		try {
			strPollResponse = Util.readFile(pathname);
			System.out.println("strFileContents: " + strPollResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		deleteRequestBuilder.buildDeleteRequest(strPollResponse);
		
	}

}
