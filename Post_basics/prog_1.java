package Post_basics;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class prog_1 {

	public static void main(String[] args) {
       RestAssured.baseURI="https://reqres.in/";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when().post("api/users")
		.then().log().all().extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		
		String h=js.getString("name");
		System.out.println("*************************");
		System.out.println(h);
		String h1=js.getString("createdAt");
		System.out.println(h1);
	}

}