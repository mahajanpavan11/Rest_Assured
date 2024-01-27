package ComplexNestedJsonObject;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import NestedJsonArrayToPoJo.EmployeePOJOClass;
import NestedJsonArrayToPoJo.employeeAddress;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestComplexNestedJSONObject {

/*     "companyName" :"XYZ Ltd",
	   "Street": "Arifac Avenue",
	   "City": "Vikroli, Mumbai",
	   "State": "Maharastra",
	   "pin code":400601,
	   "BankAccounts":["HDFC","SBI","AXIS"]    */

	@Test
	public void createUser() throws JsonProcessingException
	{
		//create request payload
		NestedJSONPojoClass requestPayload = new NestedJSONPojoClass();

		requestPayload.setCompanyName("XYZ Ltd");
		requestPayload.setCity("Arifac Avenue");
		requestPayload.setState("Vikroli , Mumbai");
		requestPayload.setPincode("400601");

		List<String> banks = new ArrayList<String>();
		banks.add("HDFC");
		banks.add("SBI");
		banks.add("AXIS");
		requestPayload.setBankAccount(banks);

		EmployeePOJOClass emp1 = new EmployeePOJOClass();
		EmployeePOJOClass emp2 = new EmployeePOJOClass();
		EmployeePOJOClass emp3 = new EmployeePOJOClass();

		emp1.setFirstName("Pavan");
		emp1.setLastName("Mahajan");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSallary(10000.56);
		employeeAddress emp1Address = new employeeAddress();
		emp1Address.setStreet("Park Avenue");
		emp1Address.setCity("Thane");
		emp1Address.setState("Maharastra");
		emp1Address.setPincode(400601);	
		emp1.setAddress(emp1Address);


		emp2.setFirstName("Akash");
		emp2.setLastName("Wagmare");
		emp2.setGender("Male");
		emp2.setAge(30);
		emp2.setSallary(34000);
		employeeAddress empAddress = new employeeAddress();
		empAddress.setStreet("Plot %");
		empAddress.setCity("Pune");
		empAddress.setState("Maharastra");
		empAddress.setPincode(400342);	
		emp2.setAddress(empAddress);



		emp3.setFirstName("Ashish");
		emp3.setLastName("Das");
		emp3.setGender("Male");
		emp3.setAge(39);
		emp3.setSallary(55000);

		empAddress.setStreet("Plot 8");
		empAddress.setCity("Dwarka");
		empAddress.setState("New Delhi");
		empAddress.setPincode(110066);	
		emp3.setAddress(empAddress);

		List<EmployeePOJOClass> employees = new ArrayList<EmployeePOJOClass>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);

		requestPayload.setEmployeeList(employees);

		//Convert Class object to JSON Object as String
		ObjectMapper objectMapper = new ObjectMapper();

		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);


		RequestSpecification requestSpec = RestAssured.given();

		//specify URL
		requestSpec.baseUri("http://httpbin.org/post");

		//specify content type and request payload
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(payload);
		Response response = requestSpec.post();

		System.out.println("------------response body-----------------");
		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200, "check for status code.");


	}

}
