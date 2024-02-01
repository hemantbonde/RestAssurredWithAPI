package apitestcase;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestCase2 {
	@Test
	public void create() {
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy","deepak");
	jobj.put("createdOn","string");
	jobj.put("projectId","string");
	jobj.put("projectName","deepak_pro-2");
	jobj.put("status","ongoing");
	jobj.put("teamSize",10);
	  
	  given()
		.body(jobj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	  	}

}
