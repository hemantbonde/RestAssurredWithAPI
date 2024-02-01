package responses;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponce {
	@Test
	public void validateresponce() {
		String expectedproject = "TY_PROJ_1003";
		Response response = when()
				.get("http://localhost:8084/projects");
		List<String> projectid = response.jsonPath().get("projectId");
		String actualproject = null;
		 for(String project:projectid) {
			 if(project.equals(expectedproject)) {
				 actualproject=project;
			 }
		 }
		 Assert.assertEquals(actualproject, expectedproject);
		
	}

}
