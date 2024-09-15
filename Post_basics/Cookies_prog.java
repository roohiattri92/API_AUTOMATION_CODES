package Post_basics;



import Payloads.Cookies;
import io.restassured.RestAssured;
import static io.restassured.RestAssured .*;

public class Cookies_prog {

	public static void main(String[] args) 
	{
 
		
RestAssured.baseURI="https://postman-echo.com/";
		
		String response=given().log().all().cookies(Cookies.Cookies_data())
		//.header("Content-Type", "application/json")
		.when().post("cookies/set")
		.then().log().all().assertThat().statusCode(500)
		.extract().response().asString();
		
		System.out.println(response);
				
		
		

	}

}