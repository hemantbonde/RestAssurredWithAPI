package crudwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Postwithbdd {
@Test
public void post() {
	Random random=new Random();
	int randomNo = random.nextInt(100);
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy","ram"+randomNo);
	jobj.put("projectName","abc"+randomNo);
	jobj.put("status","completed");
	jobj.put("teamSize",7);
	given()
		.body(jobj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	
	
}
}
