package com.ApiAutomationFramework_TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ApiAutomationFramework_APIs.CreateCustomerAPIs;
import com.ApiAutomationFramework_ExtentReportListeners.ExtentListeners;
import com.ApiAutomationFramework_SetUp.BaseTest;
import com.ApiAutomationFramework_Utilities.DataUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class CreateCustomerTest extends BaseTest{

	@Test(dataProviderClass = DataUtils.class,dataProvider = "data")
	public void validateCreateCustomreAPI(String name,String email,String description) {
		
		
		Response response =  CreateCustomerAPIs.sendPostRequestToCreateCustomreWithValidKey(name, email, description);		
	  
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "data")
	public void invalidCreateCustomreAPI(String name,String email,String description) {
				
		Response response = CreateCustomerAPIs.sendPostRequestToCreateCustomreWithInvalidKey(name, email, description);
	  
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 401);	
		
	}
	
	
	
	
}
