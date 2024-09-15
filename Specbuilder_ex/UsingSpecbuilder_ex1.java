package Specbuilder_ex;
import static io.restassured.RestAssured.given;

import Payloads.Payload_1;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UsingSpecbuilder_ex1 {

	public static void main(String[] args) 
	{
		RequestSpecification req= new RequestSpecBuilder()
		.setBaseUri("https://reqres.in").setContentType(ContentType.JSON).build();
				
				
		 RequestSpecification res=given().log().all().spec(req)
	          .body(Payload_1.addData("raman", "qa"));
		
		 ResponseSpecification resp=new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(201)
				.expectHeader("Server", "cloudflare").build();
		
	     String response=res.when().post("api/users")
		       .then().log().all().spec(resp)
		       .extract().response().asString();
	     System.out.println(response);
		
		

	}

}
