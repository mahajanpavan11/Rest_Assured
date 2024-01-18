package Session05;

import org.testng.Assert;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class ValidResponseStatusCode {

	//	https://reqres.in/
	//	https://reqres.in/api/users/2

	@Test(enabled=false)
	public void GetSingleUser()
	{
		// specify base URI
		baseURI="https://reqres.in/api/users/2";

		// get request specification of the request
		RequestSpecification requestspec=given();

		// call get method
		Response response=requestspec.get();

		// get response code
		int statuscode=response.getStatusCode();

		// validate actual status code with expected
		Assert.assertEquals( statuscode, 200," correct status code recieve");

		// validate actual status line with expected
		String statusline=response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK", "incorrect status line recieve");

	}

	@Test(enabled=false)
	public void GetSingleUserUsingValitableresponse()
	{
		// specify base URI
		baseURI="https://reqres.in/api/users/2";

		// get request specification of the request
		RequestSpecification requestspec=given();

		// call get method
		Response response=requestspec.get();

		ValidatableResponse validres=response.then();

		// status code
		validres.statusCode(200);

		// status line
		validres.statusLine("HTTP/1.1 200 OK");

	}

	@Test
	public void GetSingleUserBddStyle()
	{
		given()

		.when()
		     .get("https://reqres.in/api/users/2")

		.then()
		       .statusCode(200)
		       .statusLine("HTTP/1.1 200 OK");

	}


}
