package Get_basic_codes;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class prog_1 {

	public static void main(String[] args) 
	{
       RestAssured.baseURI="https://reqres.in/";//step-1
		
		String response= given().log().all().headers("Connection","keep-alive")// 2
		.when().get("api/users/2")// 3rd// path params is a part of when section
		.then().log().all().extract().response().asString();// 4th
		
		System.out.println(response);
		

	}

}
