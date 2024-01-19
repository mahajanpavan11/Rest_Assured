package API_Key_Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiKeyAuthentication {
	
	// https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
	  
	@Test
	public void GetWetherDataByCity() 
	{
		   // Create RequestSpecification
		
		RequestSpecification requestsec= RestAssured.given();
		requestsec.queryParam("City Name", "Mumbai").queryParam("AppId", " Api Key");
		requestsec.baseUri("https://api.openweathermap.org");
		requestsec.basePath("");  // miss some details due to Login Website
		
		Response response=requestsec.get();
		
		Assert.assertEquals(response.statusCode()/*actual*/, 200,"check for status code");
		
		System.out.println("Response status line: "+response.statusLine());	
		System.out.println("Response body: "+response.asString());
		
		
		
		
	}
	

}
