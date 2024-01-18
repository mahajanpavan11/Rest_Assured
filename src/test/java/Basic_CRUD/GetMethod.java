package Session03;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetMethod {// to get or read data from server
	
	// https://reqres.in/api/users?page=2
	
	@Test
	public void test01()  // Get method
	{
		Response res=get("https://reqres.in/api/users?page=2");
		
		System.out.println("status code "+res.getStatusCode());
		System.out.println("response body  "+res.getBody().asString());
		System.out.println("time "+res.getTime());
		System.out.println("response header  "+res.getHeader("content-type"));
		
                               // validate status code 
                               // expected status code 200
		int expected=200;
		int actual=res.getStatusCode();
		Assert.assertEquals(expected, actual);
		
	}	
	
	@Test
	public void test02()// given when then   // Get as a BDD style
	{
		//RestAssured.baseURI="https://reqres.in/api/users";
		baseURI="https://reqres.in/api/users";
		
		given().
		queryParam("page", "2").
		when().get().
		then().statusCode(200);	
	}
}
