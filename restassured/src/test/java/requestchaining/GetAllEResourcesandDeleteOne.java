package requestchaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

public class GetAllEResourcesandDeleteOne {
	@Test
	public void testCase1() {
	      Response response = when()
			 .get("http://localhost:8084/projects");
	      
	      String proid = response.jsonPath().get("[3].projectId");
	      given()
	      	.pathParam("projectId", proid)
	      .when()
	      	.delete("http://localhost:8084/projects/{projectId}")
	      .then()
	      	.assertThat().statusCode(204)
	      	.log().all();
			 
	 
	}

}
