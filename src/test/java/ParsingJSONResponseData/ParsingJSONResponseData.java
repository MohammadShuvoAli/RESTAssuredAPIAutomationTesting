package ParsingJSONResponseData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

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
	
	@Test(priority=2)
	void testJsonResponseAssert() {
		
		Response res = given()
				.contentType("ContentType.JSON")
				
			.when()
				.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(), 200); // validation 1	
		Assert.assertEquals(res.header("Content-Type"), "application/json"); // validation 2
		
		String bookname = res.jsonPath().get("book[2].title").toString();
		Assert.assertEquals(bookname, "To Kill a Mockingbird");
		
	}
	
}
