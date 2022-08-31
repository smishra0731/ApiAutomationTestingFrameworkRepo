package com.ApiAutomationFramework_APIs;

import static io.restassured.RestAssured.given;

import com.ApiAutomationFramework_SetUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPIs extends BaseTest {

	public static Response sendDeleteRequestToDeleteCustomreWithValidId(String id) {

		Response res = given().auth().basic(config.getProperty("validSecretKey"), "")
		.delete(config.getProperty("createCustomerEndPoint")+"/"+id);
		
		return res;
	}
}
