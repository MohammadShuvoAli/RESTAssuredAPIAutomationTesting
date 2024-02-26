package Cookies;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;

public class Cookies {

    @Test(priority=1)
    void testCookie() {
        given()
        .when()
            .get("https://www.google.com/")
        .then()
            .statusCode(200)
            .cookie("AEC", not(equalTo("Ae3NU9Ne-UmWjsSi-jgYvIjiRiRR-sv4uYydAUnANevGqGVSFvVjIlaJcw")))
            .log().all();
    }

    @Test(priority=2)
    void getCookiesInfo() {
        Response response = given()
        .when()
            .get("https://www.google.com/");

        // Get single cookie info
        String cookieValue = response.getCookie("AEC");
        System.out.println("Value of cookie is====>" + cookieValue);

        // Get all cookies info
        response.getCookies().forEach((name, value) -> {
            System.out.println("Cookie Name: " + name);
            System.out.println("Cookie Value: " + value);
            System.out.println("------------------------------");
        });
    }
}
