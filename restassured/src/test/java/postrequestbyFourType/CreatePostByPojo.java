package postrequestbyFourType;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

import restassured.PojoLibraries;

public class CreatePostByPojo {
	@Test
	public void Create() {
		Random random = new Random();
		int randomNo = random.nextInt(200);
		
		PojoLibraries pLib = new PojoLibraries("December"+randomNo, "abds"+randomNo, "Ongoing", 40);
		
		given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.statusCode(201)
			.log().all();
	}

}
