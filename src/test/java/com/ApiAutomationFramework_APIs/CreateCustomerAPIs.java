package com.ApiAutomationFramework_APIs;

import static io.restassured.RestAssured.given;

import com.ApiAutomationFramework_SetUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPIs extends BaseTest {

	public static Response sendPostRequestToCreateCustomreWithValidKey(String name,String email,String description) {
		
		Response res = given().auth().basic(config.getProperty("validSecretKey"), "")
		.formParam("name", name).formParam("email", email).formParam("description", description).post(config.getProperty("createCustomerEndPoint"));
		
		return res;
	}

	public static Response sendPostRequestToCreateCustomreWithInvalidKey(String name,String email,String description) {

		Response res = given().auth().basic(config.getProperty("invalidSecretKey"), "")
		.formParam("name", name).formParam("email", email).formParam("description", description).post(config.getProperty("createCustomerEndPoint"));

		return res;
	}

}
