package securityauth;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OauthSecond {
	@Test
	public void valid() {
	Response respo = given()
	.formParam("client_id","appYT")
	.formParam("client_secret","4a3b4cd3ecd40d8937bd8eacf049251fb8161b92")
	.formParam("grant_type","client_credentials")
	.formParam("redirect_uri","https://www.example.com")
	.when().post("http://coop.apps.symfonycasts.com/token");
	String token = respo.jsonPath().get("access_token");
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID",2563)
	.when()
	.post("http://coop.apps.symfonycasts.com/api/USER_ID/eggs-count")
	.then().log().all();
	}
}

