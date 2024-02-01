package securityauth;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class OtherAUth {
	@Test
	public void preeptiveAuth() {
	given()
		.auth()
		.preemptive().basic("rmgyantra", "rmgy@9999")
	.when()
		.get("http://localhost:8084/login")
		.then().log().all();
	}
	
	@Test
	public void digestiveAuth() {
		//server should ask for authentication
		//secured than preemptive 
		//creadentials go in encrypted format
	given()
		.auth()
		.digest("rmgyantra", "rmgy@9999")
	.when()
		.get("http://localhost:8084/login")
		.then().log().all();
	}

}
