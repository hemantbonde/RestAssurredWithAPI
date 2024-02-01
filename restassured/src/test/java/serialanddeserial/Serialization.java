package serialanddeserial;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import restassured.PojoLibraries;

public class Serialization {
	@Test
	public void serial() throws JsonGenerationException, JsonMappingException, IOException {
		PojoLibraries pObj = new PojoLibraries("Hemant123", "tyss6568", "completed", 20);
		ObjectMapper mapper = new ObjectMapper();
		//prettyprint==>print in json object format
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./JsonValue"), pObj);
	}

}
