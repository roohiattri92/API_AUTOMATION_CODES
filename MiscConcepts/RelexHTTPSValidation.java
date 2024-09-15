package MiscConcepts;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RelexHTTPSValidation {
	

public static void main(String[] args) 
	
	{
		
		File f=new File("C:\\API_automation\\practice_for_test.postman_collectionhhh.json");
		File image=new File("C:\\Users\\roohi\\Pictures\\Screenshots\\Screenshot (8).png");
		RestAssured.baseURI="https://httpbin.org";
		String response=given().relaxedHTTPSValidation()
		.log().all().header("Content-Type","multipart/form-data")
		
		.multiPart("file",f)
		.multiPart("file1",image)//convert byte format
		.when().post("post")
		.then().log().all().extract().response().asString();
		
		System.out.println(response);
		
		
		JsonPath js=new JsonPath(response);
		String response_data=js.getString("files.file");
		System.out.println(response_data);
		
		if(response_data.contains("New Request"))
		{
			System.out.println("Test case is pass");
		}
		
	}

}


