package Response_Header;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ValidateResponseHeader {
	// https://reqres.in/api/users/2
	// https://reqres.in  Specify base URI
	@Test
	public void getSingleUser()
	{
		// Get RequestSpecification
		RequestSpecification requestSpec=RestAssured.given();
		
		// Specify base URI
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("https://reqres.in/api/users/2");
		
		// create get request
		Response response=requestSpec.get();
		
		// validate response header 
		// header method
		//String contentType=response.header("Content-Type");
		//System.out.println("Value of connection "+contentType);
		
		// getHeader method
		String connection=response.getHeader("Connection");
		System.out.println("Value of connection "+connection);
		
		 // read all response headers attributes/keys and print values
		Headers headerslist=response.getHeaders();
		
		// for each loop to list
		for(Header header:headerslist)
		{
			System.out.println(header.getName()+":"+ header.getValue());
		}
		
		// validate header content type, Expected =Typevaluetext/html; charset=utf-8
		String contentType=response.header("Content-Type");
		Assert.assertEquals(contentType,"Typevaluetext/html; charset=utf-8"," Header content type missmatch");
		
	}

}
