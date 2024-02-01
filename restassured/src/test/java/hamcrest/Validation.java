package hamcrest;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Validation {
@Test
public void check() {
	when()
		.get("http://localhost:8084/projects")
	.then()
		.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.assertThat().body("[0].projectId", Matchers.equalTo("TY_PROJ_1003"))
		.log().all();
		
}
}
