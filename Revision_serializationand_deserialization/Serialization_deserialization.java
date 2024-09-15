package Revision_serializationand_deserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class Serialization_deserialization 
{
	
	@Test
	public void jsondata1()
	{
		JSONObject payload= new JSONObject();// like map we can use JSONObject it consume less memory.
		payload.put("name","harry");
		payload.put("job", "QA");
		payload.put("id", 12);
		
		RestAssured.baseURI="https://reqres.in/";
		
	    Response res=	given().log().all().header("content-Type", "application/json").body(payload.toJSONString())
		.header("content-type","application/json")
		.when().post("api/users")
		.then().log().all().extract().response();
	     System.out.println(res);
	     
		
		
	}

}
