package com.customer.rti.irmark;

import java.io.FileNotFoundException;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.rti.fps.irmark.IRMarkGenerator;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class IRMarkGeneratorImplTest extends TestCase {

	@Autowired
	IRMarkGenerator irMarkGenerator;
	
	@Test
	public void testGenerateIRMark() throws FileNotFoundException, Exception {
		
		String filePath = "/home/developer/rti-workspace/RTIGateway/samples_input_from_tests/1_SUBMISSION_REQUEST.xml";
		String generatedIRMark = irMarkGenerator.generateIRMark(filePath);
		System.out.println("generatedIRMark: " + generatedIRMark);
		Assert.assertEquals("IR Mark generated should be '/Qal//2vd1J+iIAMc91uY4OjpUU='","/Qal//2vd1J+iIAMc91uY4OjpUU=", generatedIRMark);
	}
}
