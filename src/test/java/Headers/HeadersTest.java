package Headers;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersTest {

    @Test(priority=1)
    void testHeaders() {
        given()
        .when()
            .get("https://www.google.com/")
        .then()
            .header("Content-Type", "text/html; charset=ISO-8859-1")
            .and()
            .header("Content-Encoding", "gzip")
            .and()
            .header("Server", "gws")
            .and()
            .statusCode(200)
            //.log().headers() // only for headers 
        	.log().all();
    }

    @Test(priority=2)
    void getHeaders() {
        Response res = given()
        .when()
            .get("https://www.google.com/");

        Headers headers = res.getHeaders();

        for (Header header : headers.asList()) {
            System.out.println(header.getName() + "       " + header.getValue());
        }
    }
}
