package crudwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Deleteresource {
	@Test
	public void delete() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_804")
		.then()
			.assertThat()
			.statusCode(204);
			
	}
	

}
