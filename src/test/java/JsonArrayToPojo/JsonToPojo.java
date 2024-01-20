package JsonArrayToPojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class JsonToPojo {// Json array is collection of JSON Objects or List Of Objects

	@Test
	public void jsonArray() throws JsonProcessingException
	{
		// create 1st employee object
		
		Employee em1=new Employee();
		em1.setFirstname("Akash");
		em1.setLastname("mishra");
		em1.setGender("male");
		em1.setAge(28);
		em1.setSalary(25000.50);

		// create 2st employee object
		
		Employee em2=new Employee();
		em2.setFirstname("Ankush");
		em2.setLastname("Wagh");
		em2.setGender("male");
		em2.setAge(30);
		em2.setSalary(23000.50);

		// create 2st employee object
		
		Employee em3=new Employee();
		em3.setFirstname("Prachi");
		em3.setLastname("Patil");
		em3.setGender("female");
		em3.setAge(27);
		em3.setSalary(30000.50);

		// convert list of employee

		List<Employee> listOfEmp=new ArrayList<Employee>();
		listOfEmp.add(em1);
		listOfEmp.add(em2);
		listOfEmp.add(em3);


		// convert employee class objects to Json Araay payload as string

		ObjectMapper objmap=new ObjectMapper();

		String jsonaArryPayload=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);

		System.out.println("employee class objects to json array payload");
		System.out.println(jsonaArryPayload);


		// Create RequestSpecification
		
		RequestSpecification reqspec=RestAssured.given();

		// Specify URL
		
		reqspec.baseUri("http://httpbin.org/post");
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jsonaArryPayload);
		
		// Perform post Request
		Response res=reqspec.post();
		System.out.println("-----------Response Body------------");
		res.prettyPrint();
		
		// Verify the status code
		Assert.assertEquals(res.statusCode(),200,"check for status code");
		
		// convert JsonArray to Employee class objects(Deserialization)
		ResponseBody resBody=res.getBody();
		
		JsonPath jsonpth=resBody.jsonPath();
		
		List<Employee> allEmp=jsonpth.getList("json",Employee.class);
		
		System.out.println("----------Emoployee objects in ResponseBody----------------");
		
		for(Employee emp:allEmp)
		{
			System.out.println(emp.getFirstname()+" "+emp.getLastname());
		}
		
		
		
	}

}
