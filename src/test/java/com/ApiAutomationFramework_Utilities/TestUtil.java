package com.ApiAutomationFramework_Utilities;

import org.json.JSONObject;

public class TestUtil {

	
	public static boolean jsonHasKey(String json, String key) {
		
		JSONObject jsonObject = new JSONObject(json);
		
		return jsonObject.has(key);		
	}
	
	public static String getJsonKeyValue(String json, String key) {
		
		JSONObject jsonObject = new JSONObject(json);
		
		return jsonObject.get(key).toString();
		
	}
	
}
