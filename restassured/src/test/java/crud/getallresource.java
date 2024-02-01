package crud;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getallresource {
	@Test
	public void get() {
		 Response response = RestAssured.get("http://localhost:8084/projects");
		// printing different ways:
		// response.prettyPrint();
		   response.prettyPeek();
		 //System.out.println(response.asString());
		   System.out.println(response.getContentType());
		   System.out.println(response.getStatusCode());
		   System.out.println(response.getTime());
		   System.out.println(response.getTimeIn(TimeUnit.SECONDS));
		   System.out.println(response.getHeaders());
		   System.out.println(response.getSessionId());
		   /*print
		   ValidatableResponse validateresponse = response.then();
		   validateresponse.log().all();
		   */
	}

}
