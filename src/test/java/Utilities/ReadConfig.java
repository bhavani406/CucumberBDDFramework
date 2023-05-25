package Utilities;
import java.io.*;
import java.util.Properties;

import StepDefinition.StepDef;

public class ReadConfig {
	static Properties prop= new Properties();
	static String projectPath = System.getProperty("user.dir");
	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
		
	}
	// get the properties from prop file
	public static void getProperties() {
		
		try {		
			InputStream input= new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			prop.load(input);
			String browser= prop.getProperty("browser");
			System.out.println(browser);
			StepDef.browserName=browser;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
			
	}
	//set data to properties file
public static void setProperties() {
		
		try {		
			OutputStream output= new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
//			prop.setProperty("browser", "gecho");
			prop.setProperty("result", "pass");
			prop.store(output, "comments");
						
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		
	}

}
