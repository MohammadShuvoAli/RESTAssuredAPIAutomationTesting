package ParsingJSONResponseData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJSONResponseData {
  
	@Test(priority=1)
	void testJsonResponse() {
		
		given()
		.contentType("ContentType.JSON")
		
		.when()
			.get("http://localhost:3000/store")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			.body("book[2].title", equalTo("To Kill a Mockingbird"));
		
	}
	
	@Test(priority=2)
	void testJsonResponseBodyData() {
		
		Response res = given()
				.contentType("ContentType.JSON")
				
			.when()
				.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(), 200); // validation 1	
		Assert.assertEquals(res.header("Content-Type"), "application/json"); // validation 2
		
		String bookname = res.jsonPath().get("book[2].title").toString();
		Assert.assertEquals(bookname, "To Kill a Mockingbird");
		
	}
	
	@Test(priority=3)
	void testResponseBodyDataJsonObject() {
		
		Response res = given()
				.contentType("ContentType.JSON")
				
			.when()
				.get("http://localhost:3000/store");
		
		String responseBody = res.getBody().asString(); // Get the response body as a string
	    JSONObject jsonObject = new JSONObject(responseBody); // Create a JSONObject from the response body

	    JSONArray booksArray = jsonObject.getJSONArray("book");
	    for (int i = 0; i < booksArray.length(); i++) {
	    	JSONObject bookObject = booksArray.getJSONObject(i);
	        String bookTitle = bookObject.getString("title");
	        String bookAuthor = bookObject.getString("author");
	        String bookCategory = bookObject.getString("category");
	        int bookPrice = bookObject.getInt("price");

	        System.out.println("Title: " + bookTitle);
	        System.out.println("Author: " + bookAuthor);
	        System.out.println("Category: " + bookCategory);
	        System.out.println("Price: " + bookPrice);
	        System.out.println("-----------------------------");
			
		}
		
	}
	
	@Test(priority=4)
	void testTitleAvailability() {
	    Response res = given()
	            .contentType("application/json")
	        .when()
	            .get("http://localhost:3000/store");

	    String responseBody = res.getBody().asString(); // Get the response body as a string
	    JSONObject jsonObject = new JSONObject(responseBody); // Create a JSONObject from the response body

	    JSONArray booksArray = jsonObject.getJSONArray("book");
	    boolean isAvailable = false;
	    for (int i = 0; i < booksArray.length(); i++) {
	        JSONObject bookObject = booksArray.getJSONObject(i);
	        String bookTitle = bookObject.getString("title");
	        if (bookTitle.equals("To Kill a Mockingbird")) {
	            isAvailable = true;
	            break; // Exit the loop early if the book is found
	        }
	    }

	    assertTrue(isAvailable, "To Kill a Mockingbird is not available");
	}
	
}
