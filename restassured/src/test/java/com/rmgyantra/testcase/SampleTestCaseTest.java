package com.rmgyantra.testcase;

import com.rmgyantra.genericUtils.BaseApiClass;
import com.rmgyantra.genericUtils.DatabaseUtility;
import com.rmgyantra.genericUtils.EndPoints;
import com.rmgyantra.genericUtils.JavaUtility;
import com.rmgyantra.pojoClass.PojoLibraries;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class SampleTestCaseTest extends BaseApiClass {
	public void testcasecreation() throws Throwable {
		JavaUtility jLib = new JavaUtility();
	    
		String expectedProjectName = "Vodafone"+jLib.randomNumber();
		PojoLibraries pobj = new PojoLibraries("Navneet", expectedProjectName, "Completed", 50);
		Response response = given()
			.body(pobj)
			.contentType(ContentType.JSON)
		.when()
			.post(EndPoints.ADDPROJECT);
		String responseProjectName = response.jsonPath().get("projectName");
		response.then()
		  .assertThat().statusCode(201)
		  .and()
		  .contentType(ContentType.JSON)
		  .log().all();
		
		dbUtil.getDataAndVerify("select * from project",4, expectedProjectName);
		
		Assert.assertEquals(responseProjectName, expectedProjectName);
		
			
	}

}
