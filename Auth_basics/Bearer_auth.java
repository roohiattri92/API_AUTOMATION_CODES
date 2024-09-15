package Auth_basics;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class Bearer_auth {

	public static void main(String[] args) 
	{
		Map<String,Object> mp=new HashMap<String,Object>();
		
		mp.put("name", "Ramanpreetkaur");
		mp.put("City", "Kalanaur");
		
		String token="Bearer 8164339b1393f0f88fc7911a1f0b314c2c3661e29771b5b859d22442776418ef";		
		RestAssured.baseURI="https://gorest.co.in";
		
	    String response=given().log().all().header("Accept","application/json")
		.body(mp).header("Authorization",token)
		.when().post("/public/v2/users")
		.then().log().all().extract().response().asString();
	
	System.out.println(response);
	System.out.println("Test case is pass");
	
		}

}
