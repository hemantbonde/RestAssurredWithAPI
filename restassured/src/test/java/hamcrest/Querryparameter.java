package hamcrest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Querryparameter {
@Test
public void query() {
	given()
		.queryParam("page", "1")
	.when()
		.get("https://reqres.in/api/users")
	.then()
		.statusCode(200)
		.log().all();
}
}
