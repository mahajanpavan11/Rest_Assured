package IgnorFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import POJOClass.Worker;
import IgnorFields.employeePojoClass;

public class TestIgnorFields {
	
	@Test
	public void testMethod1() throws JsonProcessingException
	{
		//create payload
		employeePojoClass emp1 = new employeePojoClass();
		emp1.setFirstname("Pavan");
		emp1.setLastname("Mahajan");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000);
		emp1.setMarried(true);
		emp1.setFullName("Pavan Mahajan");
	
		//serialization : convert employee class object to json payload as string

		ObjectMapper objMapper = new ObjectMapper();

		String employeeJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

		System.out.println(employeeJSON);

		// Deserialization: JSON Payload String to Employee Class Object
		String payload = "{\r\n"
				+ "  \"firstname\" : \"pavan\",\r\n"
				+ "  \"lastname\" : \"mahajan\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n"
				+ "  \"age\" : 35,\r\n"
				+ "  \"salary\" : 10000.0,\r\n"
				+ "  \"fullName\" : \"pavan Mahajan\",\r\n"
				+ "  \"married\" : true\r\n"
				+ "}";
		

		
		employeePojoClass emp2 = objMapper.readValue(payload, employeePojoClass.class);
		
		System.out.println("-----------Print after JSON Object to Class Object------------");
		System.out.println("FirstName:"+ emp2.getFirstname());
		System.out.println("LastName:"+ emp2.getLastname());
		System.out.println("Gender:"+ emp2.getGender());
		System.out.println("Age:"+ emp2.getAge());
		System.out.println("Salary:"+ emp2.getSalary());
		System.out.println("Full Name:"+ emp2.getFullName());

	}

}
