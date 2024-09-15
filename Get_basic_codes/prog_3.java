package Get_basic_codes;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class prog_3 {

	public static void main(String[] args) {
		String Actual_Last_Name="Weaver123";
		String Actual_Email="janet.weaver@reqres.in";
		int Actual_ID=2;
		
        RestAssured.baseURI="https://reqres.in/";//1
		
		String response= given().log().all().header("Connection","keep-alive")// 2
		.when().get("api/users/2")
		.then().log().all().assertThat().statusCode(200)
		.body("data.first_name",equalTo("Janet") )
		
		//.header("Age", "3197")
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String Expected_Last_Name=js.getString("data.last_name");
		String Expected_Email=js.getString("data.email");
		int Expected_ID=js.getInt("data.id");
		
		Assert.assertEquals(Actual_Last_Name, Expected_Last_Name);
		Assert.assertEquals(Actual_Email, Expected_Email);
		Assert.assertEquals(Actual_ID, Expected_ID);
		
		System.out.println("Test case is pass");

	}

}