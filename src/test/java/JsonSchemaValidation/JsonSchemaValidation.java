package JsonSchemaValidation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class JsonSchemaValidation {
	
	@Test(priority=1)
	void testJsonSchemaValidation() {
		
		given()
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.log().all()
		
		;
		
	}

}
