package HTTPRequests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {
	
	int id;
	
	// Get Request
	@Test(priority=1)
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
			
	@Test(priority=2)
	void createUser() {
		
		HashMap data = new HashMap();
		data.put("name","shuvo");
		data.put("job","SQA Engineer");
		
		
		id=given()
			.contentType("application/json")
			.body(data)
			
	    .when()
	        .post("https://reqres.in/api/users")
	        .jsonPath().getInt("id");
	        
  	//  .then()
	//        .statusCode(201)  
	//        .log().all();
	}

	
	// PUT Request		
	
		@Test(priority=3, dependsOnMethods={"createUser"})
		void updateUser() {
			
			HashMap data = new HashMap();
			data.put("name","shuvo");
			data.put("job","Software QA Engineer");
			
			
			given()
				.contentType("application/json")
				.body(data)
				
			.when()
		        .put("https://reqres.in/api/users/" + id)
		        
		    .then()
		         .statusCode(200)  
		         .log().all();
			
		}

}