package postrequestbyFourType;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateJsonobjectPost {
@Test
public void createResource() {
	Random random=new Random();
	int randomNo = random.nextInt(100);
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy","rama"+randomNo);
	jobj.put("projectName","abcd"+randomNo);
	jobj.put("status","completed");
	jobj.put("teamSize",53);
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
