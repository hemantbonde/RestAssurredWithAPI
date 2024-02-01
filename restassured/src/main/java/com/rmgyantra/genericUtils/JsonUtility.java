package com.rmgyantra.genericUtils;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class JsonUtility {
	public String getJsonResponceValue(Response response,String jsonPath) {
		 String jsonResponseValue = response.jsonPath().get(jsonPath);
		 return jsonResponseValue;
	}

}
