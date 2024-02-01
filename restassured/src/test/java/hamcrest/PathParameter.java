package hamcrest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathParameter {
	@Test
	public void parameter() {
		String project="TY_PROJ_1008";
		given()
		.pathParam("projectId",project )
	.when()
		.get("http://localhost:8084/projects/{projectId}")
	.then()
		.statusCode(200)
		.log().all();
	}

}
