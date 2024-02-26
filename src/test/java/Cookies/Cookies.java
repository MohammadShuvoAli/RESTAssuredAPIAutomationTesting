package Cookies;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Cookies {
	
	@Test
	void testCookie() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
			
		.then()
			.statusCode(200)
            .cookie("AEC", not(equalTo("Ae3NU9Ne-UmWjsSi-jgYvIjiRiRR-sv4uYydAUnANevGqGVSFvVjIlaJcw")))
			.log().all();		
	}

}
