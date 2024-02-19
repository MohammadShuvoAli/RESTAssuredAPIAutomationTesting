package HTTPRequests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {
	
	// Get Request
	@Test
	void getUsers() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
	
	// POST Request		
			
	@Test
	void createUser() {
		
		HashMap data = new HashMap();
		data.put("name","shuvo");
		data.put("job","SQA Engineer");
		
		
		given()
			.contentType("application/json")
			.body(data)
			
	    .when()
	        .post("https://reqres.in/api/users")
	        
	    .then()
	        .statusCode(201)  
	        .log().all();
	}

}
