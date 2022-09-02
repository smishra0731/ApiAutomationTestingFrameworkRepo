package com.ApiAutomationFramework_SetUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ApiAutomationFramework_Utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {

	private String configFilePath = ".\\src\\test\\resources\\properties\\config.properties";
	public static Properties config = new Properties();
	private FileInputStream fis; 
	public static ExcelReader excel = new ExcelReader("C:\\Users\\SUDHANSM\\eclipse-workspace\\ApiAutomationFramework\\src\\test\\resources\\excel\\testdata.xlsx");
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		fis =  new FileInputStream(configFilePath);
		config.load(fis);
		
		
		RestAssured.baseURI = config.getProperty("baseUri");
		RestAssured.basePath = config.getProperty("basePath");
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		
	
	}		
}
