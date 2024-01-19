package Basic_CRUD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteMethod {

	@Test
	public void test06()
	{

		// https://reqres.in/api/users/2
		RestAssured.baseURI="https://reqres.in/api/users/557";
		RestAssured.given() .

		when()
		.delete() .

		then().
		statusCode(204).
		log().all();
	}

}
