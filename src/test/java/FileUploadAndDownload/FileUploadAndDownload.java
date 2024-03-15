package FileUploadAndDownload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {
	
	//@Test(priority=1)
	void SingleFileUpload() {
		// Define the file to upload
		File myfile1 = new File(System.getProperty("user.dir") + "\\src\\test\\java\\FileUploadAndDownload\\myfile1.txt");

		// Perform file upload
		given()
		    .multiPart("file", myfile1)
		    .contentType("multipart/form-data")
		    
		.when()
		    .post("http://localhost:8080/uploadFile")
		    
		.then()
		    .statusCode(200) // Assert that the status code is 200 OK
		    .body("fileName", equalTo("myfile1.txt")) // Assert response body contains fileName
		    .log().all(); // Log all response details
		
	}
	
	@Test(priority=1)
	void MultipleFileUpload() {
		// Define the file to upload
		File myfile1 = new File(System.getProperty("user.dir") + "\\src\\test\\java\\FileUploadAndDownload\\myfile1.txt");
		File myfile2 = new File(System.getProperty("user.dir") + "\\src\\test\\java\\FileUploadAndDownload\\myfile2.txt");

		// Perform file upload
		given()
		    .multiPart("file", myfile1)
		    .multiPart("file", myfile2)
		    .contentType("multipart/form-data")
		    
		.when()
		    .post("http://localhost:8080/uploadMultipleFiles")
		    
		.then()
		    .statusCode(200) // Assert that the status code is 200 OK
		    .body("[0].fileName", equalTo("myfile1.txt")) 
		    .body("[1].fileName", equalTo("myfile2.txt")) 
		    .log().all(); // Log all response details
		
	}
	
}
