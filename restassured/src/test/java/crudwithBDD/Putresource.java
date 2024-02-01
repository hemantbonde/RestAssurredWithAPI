package crudwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Putresource {
@Test
public void put() {
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy","");
	jobj.put("projectName","");
	jobj.put("status","completed");
	jobj.put("teamSize",10);
	given()
		.body(jobj)
		.contentType(ContentType.JSON)
	.when()
		.put("http://localhost:8084/projects/TY_PROJ_1003")
	.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.statusCode(200)
		.log().all();
	
}
}
