package PathAndQueryParameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameters {
	
	// https://reqres.in/api/users?page=2&id=10
	
	@Test
	void testPathAndQueryParameters() {
		
		given()
			.pathParam("usersPath", "users") // Path Parameter
			.queryParam("page", 2) // Query Parameter
			.queryParam("id", 10) // Query Parameter
			
		.when()
			.get("https://reqres.in/api/{usersPath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
