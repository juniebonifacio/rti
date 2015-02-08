/**
 * 
 */
package com.customer.rti.fps.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.customer.rti.rim2016.v1_2.envelope.generated.GovTalkMessage;

/**
 * @author junie.bonifacio
 *
 */
public class FPSExcelReaderImpl implements FPSExcelReader {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FPSExcelReader reader = new FPSExcelReaderImpl();
		String fpsFilePath = "/home/developer/rti-workspace/HttpComponents/sample_fps/FPS_Employee.xls";
		System.out.println("fpsFilePath: " + fpsFilePath);
		reader.readFPSExcel(fpsFilePath);
		
	}
	
	
	public GovTalkMessage readFPSExcel(String fpsFilePath) {
	
		File fps = new File(fpsFilePath);
		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		try {
			fis = new FileInputStream(fps);
			
			//Get the workbook instance for the XLS file
			workbook = new HSSFWorkbook(fis);
			
			//Get the first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			//Get an iterator to all of the rows in the current sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					switch(cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.println(cell.getBooleanCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.println(cell.getNumericCellValue() + "\t\t");
						break;
						
					case Cell.CELL_TYPE_STRING:
						System.out.println(cell.getStringCellValue() + "\t\t");
						break;
					}
				}
					System.out.println();
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) { 
			ioe.printStackTrace();
		}
		finally {
			if(null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return null;
	}

}
