package com.ApiAutomationFramework_TestCases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ApiAutomationFramework_APIs.CreateCustomerAPIs;
import com.ApiAutomationFramework_APIs.DeleteCustomerAPIs;
import com.ApiAutomationFramework_SetUp.BaseTest;
import com.ApiAutomationFramework_Utilities.DataUtils;
import com.ApiAutomationFramework_Utilities.TestUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class DeleteCustomerTest extends BaseTest{

	@Test(dataProviderClass = DataUtils.class,dataProvider = "data")
	public void validateDeleteCustomreAPI(String name,String email,String description) {
		
		Response createRecordRes = CreateCustomerAPIs.sendPostRequestToCreateCustomreWithValidKey(name, email, description);
		createRecordRes.prettyPrint();
		// Get the id of created record
		String createdRecordId = TestUtil.getJsonKeyValue(createRecordRes.asString(), "id");
		System.out.println("Value of created record id is "+createdRecordId);
		
		Response deleteRecordRes =  DeleteCustomerAPIs.sendDeleteRequestToDeleteCustomreWithValidId(createdRecordId);		
		deleteRecordRes.prettyPrint();
		// Get the value of key from json of deleted record
		String deletedRecordId = TestUtil.getJsonKeyValue(deleteRecordRes.asString(), "id");
		System.out.println("Value of deleted record id is "+deletedRecordId);
				
		// Verify createdId and deletedId are same
		Assert.assertEquals(createdRecordId, deletedRecordId,"Both ids are not matching...!");

		// Validate fields in response using JSONObject
		Assert.assertTrue(TestUtil.jsonHasKey(deleteRecordRes.asString(), "id"),"Id is not present in response");
		Assert.assertTrue(TestUtil.jsonHasKey(deleteRecordRes.asString(), "object"),"Object is not present in response");
		Assert.assertTrue(TestUtil.jsonHasKey(deleteRecordRes.asString(), "deleted"),"Object is not present in response");		
		Assert.assertEquals(deleteRecordRes.statusCode(), 200);
	}	
}
