package Querry_Param;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CheckQuerryParameter {

	// https://reqres.in/api/users/2
	// https://reqres.in  Specify base URI

	@Test
	public void filterData()
	{
		// Get request specification for the given request
		RequestSpecification requestspec=RestAssured.given();

		// specify URL
		requestspec.baseUri("https://reqres.in");
		requestspec.basePath("/api/users");
		requestspec.queryParam("page", 2).queryParam("id",10);

		// perform get request
		Response response=requestspec.get();

		// read response body
		String responsebodystring=response.getBody().asString();

		// print response body
		System.out.println("Response body "+responsebodystring);

		// get json path view of response body
		JsonPath jsonpathview=response.jsonPath();

		// get first_name
		String firstname=jsonpathview.get("data.first_name");

		
		Assert.assertEquals(firstname, "Byron"," Verify first name");
		
		
	}
}
