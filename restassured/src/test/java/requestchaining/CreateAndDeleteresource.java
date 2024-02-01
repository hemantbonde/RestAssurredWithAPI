package requestchaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateAndDeleteresource {
	@Test
	public void assignment() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","employee");
		jobj.put("projectName", "long56653");
		jobj.put("status", "completed");
		jobj.put("teamSize",23);
		
		Response response =given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
		String proid = response.jsonPath().get("projectId");	
		System.out.println(proid);
		given()
	      	.pathParam("projectId", proid)
	      .when()
	      	.delete("http://localhost:8084/projects/{projectId}")
	      .then()
	      	.assertThat().statusCode(204)
	      	.log().all();

		
		
	}

}