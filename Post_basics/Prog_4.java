package Post_basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Prog_4 {

	public static void main(String[] args) throws IOException 
	{
           RestAssured.baseURI="https://reqres.in/";
		
		String response =given().log().all().header("Content-Type","application/json")
		.body(new String (Files.readAllBytes(Paths.get("‪‪C:\\Users\\roohi\\Desktop\\filefor_post_code.txt"))))
		.when().post("api/users")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		System.out.println(response);

			
		
		
	

	}

}
