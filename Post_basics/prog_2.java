package Post_basics;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import Payloads.Payload_1;

public class prog_2 {

	public static void main(String[] args) {
		 RestAssured.baseURI="https://reqres.in/";
			
			String response=given().log().all().header("Content-Type","application/json")
			.body(Payload_1.addData("ramanpreet","QA"))
			.when().post("api/users")
			.then().log().all().extract().response().asString();
			
			System.out.println(response);

		}

	}