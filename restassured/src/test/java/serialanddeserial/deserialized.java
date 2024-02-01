package serialanddeserial;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;

import restassured.PojoLibraries;


public class deserialized {
	@Test
	public void deserial() throws Exception, Throwable, Throwable {
	ObjectMapper mapper = new ObjectMapper();
	PojoLibraries pObj = mapper.readValue(new File("./JsonValue"), PojoLibraries.class);
	System.out.println(pObj.getCreatedBy());
	System.out.println(pObj.getProjectName());
	System.out.println(pObj.getStatus());
	System.out.println(pObj.getTeamSize());
	}
}
