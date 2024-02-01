package postrequestbyFourType;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePostByJsonFile {
@Test
public void createpost() {
	File file = new File("./src/test/resources/jsondata.json");
	given()
		.body(file)
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
