package responses;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponse {
@Test
public void validate() {
	String expectedProjectName="abc86";
	//get  project  from resource
	Response response = when()
							.get("http://localhost:8084/projects");
	//inorder to set json path we break the response
	String actualprojectName = response.jsonPath().get("[0].projectName");
						response.then()
								.assertThat().statusCode(200)
								.and()
								.contentType(ContentType.JSON)
								.log().all();
	//compare actual and expected data					
	Assert.assertEquals(expectedProjectName, actualprojectName);
	
	
}
}
