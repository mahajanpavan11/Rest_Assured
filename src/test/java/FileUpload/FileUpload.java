package FileUpload;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class FileUpload {
	
	@Test
	public void uploadFile()
	{
		//Create File upload
		File testfile=new File("C:\\Users\\pavan\\Postman\\files\\wait.txt");
		
		//create requestSpcification
		RequestSpecification req=RestAssured.given();
		
		// specify URL
		req.baseUri("http://httpbin.org/post");
		
	//	req.multiPart("file",testfile2);         upload 2 or more file
		req.multiPart("file",testfile);
		req.contentType("multipart/form-data");
		
		// perform post request
		Response res=req.post();
		
		// print request body
		res.prettyPrint();
		
		// validate response code
		Assert.assertEquals(res.statusCode(), 200);
		
	}

}
