package JsonSchemaValidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class JsonSchemaValidation {
    
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\StoreAPISchema.json";

    @Test(priority=1)
    void testJsonSchemaValidation() {
        System.out.println("File path: " + filePath); // Print the file path
        
        given()
        
        .when()
        
            .get("http://localhost:3000/store")
            
        .then()
        
            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(filePath));
    }
}
