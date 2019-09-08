package Cinfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import FlightFollowing.BaseClass;

public class PropertiesFile {
	static  Properties prop = new Properties();	
	static String Filepath = System.getProperty("User.dir");

	public static void main(String[] args) {

	}
	public static void GetProperties() {

		try {

			InputStream input = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\RCAS\\src\\Cinfig\\ConfigFile.properties");
			prop.load(input);
			String browser = prop.getProperty("Browser");
			System.out.println(browser);
			BaseClass.BrowserName=browser;
		} 

		catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	public static void setProperties() {
		try {
			
			OutputStream output = new FileOutputStream(Filepath+"\\Cinfig\\ConfigFile.properties");
			prop.setProperty("Test Run", "Successfully");
			prop.store(output,"Browser Opened Successful");



		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}


	}




}
