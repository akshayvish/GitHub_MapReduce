package com.soulpatch.fileUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	static String propertiesFile = "/src/resources/GitURLs.properties";

	public static String readGitProperties(String propName) {
		String property = null;
		try{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propertiesFile);
		prop.load(fis);
		property = prop.getProperty(propName);
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property;
	}
}
