package Common_fnx_spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Request_response_Spesification 
{
	
	public static RequestSpecification requesMothod()
	{
		
		RequestSpecification req= new RequestSpecBuilder()
	  .setBaseUri("https://reqres.in").setContentType(ContentType.JSON).build();
		
		return req;
	}
	
	
	public static ResponseSpecification responseMothod1( int statusCode)
	{
		ResponseSpecification resp=new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(statusCode)
				.expectHeader("Server", "cloudflare").build();
		return resp;
	}

}
