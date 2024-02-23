package WaysToCreatePostRequestBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class WaysToCreatePostRequestBody {

    String id;

    //@Test(priority = 1)
    void testPostRequestUsingHashMap() {

        HashMap data = new HashMap();
        data.put("name", "Shuvo");
        data.put("location", "BD");
        data.put("phone", "77777777777");

        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);

        id = given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("http://localhost:3000/students")
            .jsonPath().getString("id");

        given()
            
        .when()
            .get("http://localhost:3000/students/" + id)
        .then()
            .statusCode(200)
            .body("name", equalTo("Shuvo"))
            .body("location", equalTo("BD"))
            .body("phone", equalTo("77777777777"))
            .body("courses[0]", equalTo("C"))
            .body("courses[1]", equalTo("C++"))
            .log().all();
    }

    //@Test(priority = 1)
    void testPostRequestUsingJsonLibrary() {

        JSONObject data = new JSONObject();
        
        data.put("name", "Shuvo");
        data.put("location", "BD");
        data.put("phone", "77777777777");

        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);

        id = given()
            .contentType("application/json")
            .body(data.toString()) // getting as JSON so need to convert into string
        .when()
            .post("http://localhost:3000/students")
            .jsonPath().getString("id");

        given()
            
        .when()
            .get("http://localhost:3000/students/" + id)
        .then()
            .statusCode(200)
            .body("name", equalTo("Shuvo"))
            .body("location", equalTo("BD"))
            .body("phone", equalTo("77777777777"))
            .body("courses[0]", equalTo("C"))
            .body("courses[1]", equalTo("C++"))
            .log().all();
    }

    
    @Test(priority = 1)
    void testPostRequestUsingPOJO() {

        PlainOldJavaObject data = new PlainOldJavaObject();
        
        
        data.setName("Shuvo");
        data.setLocation("BD");
        data.setPhone("77777777777");

        String courseArr[] = {"C", "C++"};
        data.setCourses(courseArr);

        id = given()
            .contentType("application/json")
            .body(data)
            
        .when()
            .post("http://localhost:3000/students")
            .jsonPath().getString("id");

        given()
            
        .when()
            .get("http://localhost:3000/students/" + id)
            
        .then()
            .statusCode(200)
            .body("name", equalTo("Shuvo"))
            .body("location", equalTo("BD"))
            .body("phone", equalTo("77777777777"))
            .body("courses[0]", equalTo("C"))
            .body("courses[1]", equalTo("C++"))
            .log().all();
    }

    
    @Test(priority = 2)
    void testDelete() {
        // Use the stored ID from the POST request in the DELETE request
        given()
        
        .when()
            .delete("http://localhost:3000/students/" + id)
        .then()
            .statusCode(200)
            .log().all();
    }
}
