package crud;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Post {
	@Test
	public void post() {
	Random random=new Random();
	int randomNo = random.nextInt(100);
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy","ram"+randomNo);
    jobj.put("projectName","abc"+randomNo);
	jobj.put("status","completed");
	jobj.put("teamSize",7);
	
	RequestSpecification respospec = RestAssured.given();
	respospec.body(jobj);
	respospec.contentType(ContentType.JSON);
	Response respo = respospec.post("http://localhost:8084/addProject");
	 ValidatableResponse validate = respo.then();
	 validate.statusCode(201);
	 validate.contentType(ContentType.JSON);
	 validate.log().all();
	
	}
}
