package Session09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {

	@Test
	public void Bearertoken()
	{
		// create request specification
		RequestSpecification reqestspec=RestAssured.given();

		// specify Url  https://gorest.co.in/public/v2/users
		reqestspec.baseUri("https://gorest.co.in");
		reqestspec.basePath("/public/v2/users");


		// for post method
		JSONObject payload=new JSONObject();
		payload.put("name", "pravinmahajan");
		payload.put("Gender", "male");
		payload.put("Email", "pavan@gmail.com");
		payload.put("status", "active");

		String Authtoken="Bearer 7709c81d048e4b458b6fcb3c8d4d1f6fe5b5c427aced4e5e228bbb02673d72eb";

		reqestspec.header("Authorization", Authtoken).
		contentType(ContentType.JSON).
		body(payload.toJSONString());

		Response response=reqestspec.post();


		Assert.assertEquals(response.statusCode()/*actual*/, 201,"check for status code");

		// print status line
		System.out.println("Response status line: "+response.statusLine());	
		System.out.println("Response body: "+response.asString());


	}

}
