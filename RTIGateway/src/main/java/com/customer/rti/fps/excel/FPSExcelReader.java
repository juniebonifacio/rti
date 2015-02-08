/**
 * 
 */
package com.customer.rti.fps.excel;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;


/**
 * @author junie.bonifacio
 *
 */
public interface FPSExcelReader {

	public GovTalkMessage readFPSExcel(String fpsFilePath) throws FileNotFoundException, IOException;
	
}
