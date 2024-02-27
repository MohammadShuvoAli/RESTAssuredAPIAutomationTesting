package Headers;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;

public class Headers {
	
	@Test(priority=1)
    void testHeader() {
        given()
        .when()
            .get("https://www.google.com/")
        .then()
            .statusCode(200)
            .log().all();
    }

}
