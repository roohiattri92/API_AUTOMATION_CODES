package Get_basic_codes;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class prog_4 {

	public static void main(String[] args) {
		String Actual_First_Name_5="Rachel";
		String Actual_Last_Name_2="Funke";
		int Actual_ID_0=7;
		
		
		RestAssured.baseURI="https://reqres.in/";//1st
		
		String response=given().log().all().queryParam("page", 2).header("Connection","keep-alive")
		.when().get("api/users")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String Expected_First_Name_5=js.getString("data[5].first_name");
		String Expected_Last_Name_2=js.getString("data[2].last_name");
		int Expected_ID_0=js.getInt("data[0].id");
		
		Assert.assertEquals(Actual_First_Name_5, Expected_First_Name_5);
		Assert.assertEquals(Actual_Last_Name_2, Expected_Last_Name_2);
		Assert.assertEquals(Actual_ID_0, Expected_ID_0);
		
		System.out.println("***********Test case is Pass **********");
		
		

	}

}