package FileUploadAndDownload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {
	
	@Test(priority=1)
	void SingleFileUpload() {
		// Define the file to upload
		File myfile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\FileUploadAndDownload\\myfile.txt");

		// Perform file upload
		given()
		    .multiPart("file", myfile)
		    .contentType("multipart/form-data")
		    
		.when()
		    .post("http://localhost:8080/uploadFile")
		    
		.then()
		    .statusCode(200) // Assert that the status code is 200 OK
		    .body("fileName", equalTo("myfile.txt")) // Assert response body contains fileName
		    .log().all(); // Log all response details
		
	}
}
