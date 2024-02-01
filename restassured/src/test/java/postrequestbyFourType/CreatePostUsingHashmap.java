package postrequestbyFourType;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePostUsingHashmap {
	@Test
	public void createpost() {
		Random random = new Random();
		int randomNo = random.nextInt(200);
		
		HashMap hobj = new HashMap();
		hobj.put("createdBy", "Dells"+randomNo);
		hobj.put("projectName", "Resource"+randomNo);
		hobj.put("status", "Ongoing");
		hobj.put("teamSize", 40);
		
		given()
			.body(hobj)
			.contentType(ContentType.JSON)
	    .when()
			.post("http://localhost:8084/addProject")
	    .then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
		
		
	}
}
