package Specbuilder_ex;

import org.testng.annotations.Test;

import Common_fnx_spec.Request_response_Spesification;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;

public class Using_SpecBuilder_get {
       @Test
		public void ValidateGetRequest()
		{
			
    	   RequestSpecification req=given().log().all().queryParam("page", 2)
    			   .spec(Common_fnx_spec.Request_response_Spesification.requesMothod());
    			   
    			   
    	String Response= req .when().get("api/users").then().log().all()
    			.spec(Common_fnx_spec.Request_response_Spesification.responseMothod1(0))
    		    .extract().response().asString();
    	
    	System.out.println(Response);
		
		//common_fnx_spec package check for this program 
		
	}

}
