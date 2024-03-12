package ParsingJSONResponseData;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ParsingJSONResponseData {
  

	@Test(priority=1)
	void testJsonResponse() {
		
		given()
		.contentType("ContentType.JSON")
		
		.when()
			.get("http://localhost:3000/store")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			.body("book[2].title", equalTo("To Kill a Mockingbird"));
		
	}
	
}
