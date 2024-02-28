package Headers;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;

public class Headers {
	
	@Test(priority=1)
    void testHeaders() {
        given()
        .when()
            .get("https://www.google.com/")
        .then()
        	.header("Content-Type", "text/html; charset=ISO-8859-1")
        	.and() // for adding multiple validation
        	.header("Content-Encoding", "gzip")
        	.and()
        	.header("Server", "gws")
        	.and()
            .statusCode(200)
            .log().all();
    }

}
