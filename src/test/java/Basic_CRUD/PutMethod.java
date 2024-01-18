package Session03;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutMethod {// update record on server
	
	@Test
	public void test04()
	{
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "pavan");
		jsondata.put("job", "Tester");
		
		// https://reqres.in/api/users/2
		
		RestAssured.baseURI="https://reqres.in/api/users/557";
		RestAssured.given().header("content-type","application/json").
		contentType(ContentType.JSON).body(jsondata.toJSONString()).
		body(jsondata.toJSONString()). 
		when().
		    put().
		then().
		    statusCode(200).log().all();
	}

}
