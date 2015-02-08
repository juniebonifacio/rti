/**
 * 
 */
package com.customer.rti.fps.logic;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.rti.fps.logic.FPSGatewayService;
import com.customer.rti.fps.util.FPS;
import com.customer.rti.util.Util;

/**
 * @author junie.bonifacio
 *
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class FPSGatewaySubmitterImplTest {

	private static final Logger logger = Logger.getLogger(FPSGatewaySubmitterImplTest.class);
	
	@Autowired
	FPSGatewayService fpsSGatewaySubmitter;

	@Test
	public void testCallSubmissionRequest() throws JAXBException {
		logger.debug("start testCallSubmissionRequest");
		
		
		String pathname = "/home/developer/rti-workspace/RTIGateway/samples_input_from_tests/1_SUBMISSION_REQUEST.xml";
		pathname = Util.replaceWhiteSpaces(pathname);

		String strSubmissionRequest = "";
		try {
			strSubmissionRequest = Util.readFile(pathname);
			System.out.println("strFileContents: " + strSubmissionRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String submissionAcknowledgement = fpsSGatewaySubmitter.callSubmitFPS(
				FPS.SUBMISSION_URL, FPS.POLL_URL, strSubmissionRequest);
		Assert.assertNotNull(submissionAcknowledgement);
	}

}
