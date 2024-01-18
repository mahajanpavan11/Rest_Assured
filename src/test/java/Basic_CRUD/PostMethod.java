package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostMethod {// create a new resource on server
	
	@Test
	public void test03()  // bdd format
	{
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "prachi");
		jsondata.put("job", "QA");
		
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("content-type","application/json").
		contentType(ContentType.JSON).body(jsondata.toJSONString()).
		body(jsondata.toJSONString()). 
		when().
		    post().
		then().
		    statusCode(201).log().all();
		
	}
}
