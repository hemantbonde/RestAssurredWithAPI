package assignment;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Testcase1 {
	@Test
	public void createProject() throws Throwable {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","employee");
		jobj.put("projectName", "longh5653");
		jobj.put("status", "completed");
		jobj.put("teamSize",23);
		
		Response response = given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
		String proid = response.jsonPath().get("projectId");
		System.out.println(proid);
		response.then()
					.assertThat().statusCode(201)
					.and()
					.contentType(ContentType.JSON)
					.time(Matchers.lessThan(6000L),TimeUnit.MILLISECONDS)
					.log().all();
					
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement stat = conn.createStatement();
		String query = "select * from project";
		ResultSet result = stat.executeQuery(query);
		String databasePId=null;
		while(result.next()) {
			if(databasePId==proid) {
				databasePId=result.getString(1);
			}
			
		}
		
		Assert.assertEquals(databasePId, proid);
			
		
	}

}
