package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import restassured.PojoLibraries;

public class MultipleDataForSameRequest {
	@Test(dataProvider = "getData")
	public void multidatarequest(String createdBy,String projectName,String status,int teamSize) {
		PojoLibraries pobj = new PojoLibraries(createdBy, projectName, status, teamSize);
		given()
			.body(pobj)
			.contentType(ContentType.JSON)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.statusCode(201)
			.log().all();
		
	}
@DataProvider
public Object[][] getData(){
	Object[][] objArray = new Object[2][4];
	objArray[0][0]="data4";
	objArray[0][1]="data4 Project4";
	objArray[0][2]="Completed";
	objArray[0][3]=12;
	
	objArray[1][0]="data5";
	objArray[1][1]="data5 Project5";
	objArray[1][2]="Completed";
	objArray[1][3]=13;
	
	return objArray;
}
}
