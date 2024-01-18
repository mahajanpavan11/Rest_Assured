package Session11;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class OAuth2 {

	static String accesstoken;

	@Test
	public void GetAccessToken()
	{
		RequestSpecification reqestspec=RestAssured.given();

		// specify URL
		reqestspec.baseUri(" ");
		reqestspec.basePath(" ");

		// Basic Authorisation
		Response res=reqestspec.auth().preemptive().basic("clientId", "clientSecreate")
				.param("Grant_Type","client_credentials").post();

		res.prettyPrint();


		System.out.println("Response Code"+res.statusCode());
		System.out.println("Statusn Line"+res.statusLine());

		// Validation
		Assert.assertEquals(res.statusCode(), 200);

		// get access token from response body
		String accesstoken=res.getBody().path("access_token");

		System.out.println("Access Token"+accesstoken);

	}

	@Test(dependsOnMethods="GetAccessToken")
	public void Listinvoice()
	{
		Response res=RestAssured.given().auth().oauth2(accesstoken).queryParam("page", "3")
				.queryParam("page_size", "4").queryParam("total_count_required","true")
				.get("Total path");

		System.out.println("----ListInvoce-----");
		res.prettyPrint();

		System.out.println("Response Code"+res.statusCode());
		System.out.println("Statusn Line"+res.statusLine());

		Assert.assertEquals(res.statusCode(), 200);



	}

}
