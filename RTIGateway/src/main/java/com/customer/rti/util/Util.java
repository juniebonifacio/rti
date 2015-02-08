package com.customer.rti.util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Component;

/**
 * @author junie.bonifacio
 *
 */
@Component
public class Util {

	public static String readFile(String pathname) throws IOException {
		File file = new File(pathname);
		StringBuilder fileContents = new StringBuilder((int) file.length());
		Scanner scanner = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");

		try {
			while (scanner.hasNextLine()) {
				fileContents.append(scanner.nextLine() + lineSeparator);
			}
			return fileContents.toString();
		} finally {
			scanner.close();
		}
	}
	
	public static String replaceWhiteSpaces(String string) {	
		string = string.trim();
		string = string.replace(" ", "");
		string = string.replace("\n", "");
		string = string.replace("\r", "");
		String replaced = string.replace("\t", "");
		return replaced;
	}
}
