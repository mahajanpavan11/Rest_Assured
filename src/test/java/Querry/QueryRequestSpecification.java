package Querry;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {

	// https://reqres.in/api/users

	@Test
	public void createUser()
	{
		// create JsonData
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "pavan");
		jsonData.put("job", "QA");


		// create RequestSpecification
		RequestSpecification req=RestAssured.given();

		// specify URI
		req.baseUri("https://reqres.inhttps://reqres.in");
		req.basePath("/api/users")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString()).header("Headr1","Header Value");


		// Query details from request specification
		QueryableRequestSpecification queryrequest=SpecificationQuerier.query(req);

		// get base URI
		String retrivebaseUri=queryrequest.getBaseUri();
		System.out.println("Base URI-- "+retrivebaseUri);

		// get base Path
		String retrivebasepath=queryrequest.getBasePath();
		System.out.println("Base PATH-- "+retrivebasepath);

		// get Request Body
		String retriveBody=queryrequest.getBody();
		System.out.println("Body-- "+retriveBody);

		// get request headers
		Headers allHeaders=queryrequest.getHeaders();
        System.out.println("---Request Header----");
		
		for(Header h:allHeaders)// for each loop to get all Header 
		{
			System.out.println("Header Name:"+h.getName()+"Header Value:"+h.getValue());
			
		}
		
		
		
		
	}
}
