/**
 * 
 */
package com.customer.rti.fps.irmark;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class IRMarkGeneratorImpl implements IRMarkGenerator {

	@Autowired
	private MarkCalculator markCalculator;
	
	@Override
	public String generateIRMark(String filePath) throws FileNotFoundException, Exception {
		String irMark = null;
		
		File file = null;
		FileInputStream fis = null;
		try {
			file = new File(filePath);
			fis = new FileInputStream(file);
			irMark = markCalculator.createMark(fis);
		} catch (FileNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return irMark;
	}

}
