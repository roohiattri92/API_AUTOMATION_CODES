package Auth_basics;

import io.restassured.RestAssured;

import static io.restassured.RestAssured .*;


public class Api_key_auth {

	public static void main(String[] args) 
	{
		String Api_key="78618167aed6133ff6f4ddcccf967113";
	    RestAssured.baseURI="https://api.openweathermap.org";
	
	    String Response= given().log().all().queryParam("q", "Delhi").queryParam("appid", Api_key)
	
	    .when().get("data/2.5/weather")
	
	    .then().log().all().extract().response().asString();
	
	     System.out.println(Response);
	
	

	}
	

}
