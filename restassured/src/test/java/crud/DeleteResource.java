package crud;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteResource {
@Test
public void delete() {
	RequestSpecification reqspect = RestAssured.given();
	Response response = reqspect.delete("http://localhost:8084/projects/TY_PROJ_1004");
	
	ValidatableResponse validate = response.then();
	validate.statusCode(204);
}
}
