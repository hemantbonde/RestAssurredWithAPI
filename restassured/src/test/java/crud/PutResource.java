package crud;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutResource {
@Test
public void put() {
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy","ramu");
    jobj.put("projectName","abck");
	jobj.put("status","completed");
	jobj.put("teamSize",13);
	
	RequestSpecification respospec = RestAssured.given();
	respospec.body(jobj);
	respospec.contentType(ContentType.JSON);
	Response respo = respospec.put("http://localhost:8084/projects/TY_PROJ_1004");
	 ValidatableResponse validate = respo.then();
	 validate.statusCode(200);
	 validate.contentType(ContentType.JSON);
	 validate.log().all();
}
}
