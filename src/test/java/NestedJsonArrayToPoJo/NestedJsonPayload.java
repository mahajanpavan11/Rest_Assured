package NestedJsonArrayToPoJo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class NestedJsonPayload {
	/*	{
	  "firstName": "pavan",
	  "lastName": "mahajan",
	  "gender": "Male",
	  "age": 30,
	  "salary:10000.56,
	  "Address":{
		       "Street": "koli wada",
		       "City": "Thane Mumbai",
		       "State": "Maharastra",
		       "pin code":400601
	        }
	}                     */
	
	@Test
	public void createUser() throws JsonProcessingException
	{
		EmployeePOJOClass emp=new EmployeePOJOClass();
		emp.setFirstName("pavan");
		emp.setLastName("mahajan");
		emp.setGender("male");
		emp.setAge(30);
		emp.setSallary(10000.500);
		
		employeeAddress empAdd=new employeeAddress();
		empAdd.setStreet("koliwada");
		empAdd.setCity("thane");
		empAdd.setState("maharastra");
		empAdd.setPincode(400601);
		
		emp.setAddress(empAdd);
		
		// Convert class object to json object as string
		
		ObjectMapper objMap=new ObjectMapper();
		
		String jsonPayload=objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
         RequestSpecification reqSpec = RestAssured.given();
		
		//specify url
		reqSpec.baseUri("http://httpbin.org/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonPayload);
		
		//perform post request
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
	
		
		
	}
	

}
