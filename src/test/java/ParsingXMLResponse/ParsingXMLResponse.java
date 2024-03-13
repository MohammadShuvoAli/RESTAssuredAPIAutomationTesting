package ParsingXMLResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingXMLResponse {
	
	@Test(priority=1)
	void testXMLResponse() {
		
		given()
		
		.when()
			.get("https://mocktarget.apigee.net/xml")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.log().all();
		
	}
	
	@Test(priority=2)
	void testXMLResponseAssert() {
		
		Response res = 
		
		given()
		
		.when()
			.get("https://mocktarget.apigee.net/xml");
		
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
	}

}
