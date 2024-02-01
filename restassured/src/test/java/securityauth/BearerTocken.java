package securityauth;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTocken {
	@Test
	public void validate() {
		given()
		 .auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
			.then().log().all();
	}
}
