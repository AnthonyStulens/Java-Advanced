package com.engine.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is capable of reading txt files and converting them into objects.
 */
public class Reader {

	/**
	 * Reads a file and separates lines with the '>' tag.
	 * @param path - file path
	 * @return String of file content
	 */
	public String read(String path) {
		File file = new File(path);
		String result = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				result += line + ">";
			}
			return result;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
}