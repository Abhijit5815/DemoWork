package com.hbsp.globalutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	
	static Properties prop=new Properties();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		try {
			FileInputStream file=new FileInputStream("E:\\ak-workspace\\automation\\fb-tests-selng-pom\\"
					+"selng\\src\\main\\resource\\config.properties");
		
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		   }
	
	public String getpropertyvalue(String propname) {
		return prop.getProperty(propname);
		
	}
	
	
	
}
