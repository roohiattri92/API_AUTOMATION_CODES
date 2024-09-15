package Post_basics;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import Payloads.Payload_1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;




public class prog_3 {

	public static void main(String[] args) 
	{
		String Act_job="QA_Manager";
		String Cureent_Date="2024-08-03";
        RestAssured.baseURI="https://reqres.in/";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(Payload_1.addData("Prasad","QA_Manager"))
		.when().post("api/users")
		.then().log().all().assertThat().statusCode(201)
		.body("name", equalTo("Prasad"))
		.extract().response().asString();
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String Exp_job=js.getString("job");
		String todays_date=js.getString("createdAt");
		System.out.println(Exp_job);
		String[] date_1=todays_date.split("T");
		String first_part=date_1[0];
		String second_part=date_1[1];
		
		System.out.println(first_part);
		System.out.println(second_part);
		
		System.out.println(todays_date);
		
		
		Assert.assertEquals(Cureent_Date, first_part);
		Assert.assertEquals(Act_job, Exp_job);
	}
}