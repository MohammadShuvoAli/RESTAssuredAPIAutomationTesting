package JsonSchemaValidation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	
	String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\StoreAPISchema.json";
	
	@Test(priority=1)
	void testJsonSchemaValidation() {
		
		given()
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchema(filePath)
		
		;
		
	}

}
