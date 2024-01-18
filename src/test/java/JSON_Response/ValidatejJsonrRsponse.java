package Session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class ValidatejJsonrRsponse {

	// https://reqres.in/api/users?page=2
	// https://reqres.in  baseURI

	@Test
	public void UserListResponseBody()
	{
		// Get RequestSpecification Reference
		RequestSpecification reqspec=RestAssured.given();

		// specify BaseURI
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("api/users?page=2");

		// create get request
		Response response=reqspec.get();

		// read response body
		ResponseBody responsebody=response.getBody();

		String responseString=responsebody.asString();
		System.out.println("Response Body "+responseString);

		// check for presence of George in response body
		Assert.assertEquals(responseString.contains("George"),true,"check for presence of George");


		// Get Json path view of response body
		JsonPath jsonpathvies=responsebody.jsonPath(); //Json path  x.data[4].first_name
		String firstName=jsonpathvies.get("data[0].first_name");

		System.out.println("Email adress "+jsonpathvies.get("data[1].avatar"));
		Assert.assertEquals(firstName,"George", " check for presence of first name as george");


	}

}
