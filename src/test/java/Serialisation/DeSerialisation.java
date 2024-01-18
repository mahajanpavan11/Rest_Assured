package Session12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class DeSerialisation {
/*	json data to class object
	https://reqres.in/ 
	/api/users              */
	
	@Test
	public void CreateUser()
	{
		// create RequestSpecification
	   RequestSpecification req=RestAssured.given();
		
	   // specify URL
	   req.baseUri("https://reqres.in");
	   req.basePath("/api/users");
	   
	   // create request body
	   JSONObject jsonData=new JSONObject();
	   jsonData.put("name", "pavan");
	   jsonData.put("job", "QA Engineer");
		
	   //perform post request
	  Response response= req.contentType(ContentType.JSON)
	   .body(jsonData.toJSONString())
	   .post();
	  
	  ResponseBody responsebody=response.getBody();
	  
	  // Deserialize responseBody i.e json response body to class object
	   // class<T> is a generic form of any class of type T which is also refered to as template class 
	  JSONPostRequestResponse responseclass=responsebody.as(JSONPostRequestResponse.class);
	   
	  Assert.assertEquals(responseclass.name, "pavan","check for name");
	  Assert.assertEquals(responseclass.job, "QA Engineer","check for QA");
	   
	   
	}

}
