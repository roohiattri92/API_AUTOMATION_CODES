package Auth_basics;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Digest_auth {

	public static void main(String[] args) 
	
	{
RestAssured.baseURI="https://httpbin.org/";
		
		String response=given().auth().digest("postman","password")
		.when().get("digest-auth/undefined/postman/password")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String authentication= js.getString("authenticated");
		
		Assert.assertEquals(authentication, "true");
		
		System.out.println(authentication);
		
		System.out.println("*******test case is pass********");
		
		
		
	}

}
