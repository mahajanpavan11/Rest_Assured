package Session08;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BasicAuthorasation {
	
	@Test
	public void basicAuth()// Basic Authentication >> who you are
	{                     // Authoraisation >> what all you can access
		
		RequestSpecification reqestspec=RestAssured.given();
		
		// specify Url
		reqestspec.baseUri("http://postman-echo.com");
		reqestspec.basePath("/basic-auth");
		
		// perform get request
		Response respons=reqestspec.auth().preemptive().basic("postman", "password").get();
		
		// print status line
		System.out.println("response status"+respons.statusLine());	
		System.out.println("response body: "+respons.asString());
		
	}

	// https://httpbin.org/digest-auth/undefined/pavan/password
	@Test
	public void DigestAuth()
	{	
		RequestSpecification reqestspec=RestAssured.given();
		
		// specify Url
		reqestspec.baseUri("https://httpbin.org");
		reqestspec.basePath("/digest-auth/undefined/pavan/password");
		
		// perform get request
		//Response respons=reqestspec.get();
		Response respons=reqestspec.auth().digest("pavan", "password").get();
		
		Assert.assertEquals(respons.statusCode()/*actual*/, 200,"check for status code");
		
		// print status line
		System.out.println("Digest Auth: "+respons.statusLine());	
		System.out.println("Digest auth: "+respons.asString());
		
	}
}
