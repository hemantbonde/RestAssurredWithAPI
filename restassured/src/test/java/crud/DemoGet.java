package crud;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DemoGet {
	@Test
	public void getResponses() {
	
		when().
		 	get("https://reqres.in/api/users?page=2")
		 	.then()
		 	.log().all();
		
	}
}
