package POJO_EX;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Createnew_EMployee {

	public static void main(String[] args) throws JsonProcessingException 
	{
		Employee_info_INjava emp=new Employee_info_INjava();
		
		emp.setName("Harry");
		emp.setLocation("Delhi");
		emp.setSalary(50000f);
		emp.setJob("QA lead");
		
		ObjectMapper obj=new ObjectMapper();
		
	    // it is a class that is going to 
		//help us to serialization the data and help us to provide functionality to read and writting json
		
	   String empJson=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
	   
	   RequestSpecification req=new RequestSpecBuilder()
	   .setContentType(ContentType.JSON).setBaseUri("https://httpbin.org")
	   .build();
	   
	   RequestSpecification respec=given().log().all().spec(req).body(empJson);
	   
	    ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).build();
	   
	  Response response= respec.when().post("post").then().log().all().spec(res)
			  .extract().response();
	  
	  System.out.println(response);
	  
	  String jsonresponse=response.asString();
	  System.out.println(jsonresponse);
	  
	  //*******************************************************************************************
	  
	  //Deserialization
	  
	  /* Employee_info_INjava javadata= empJson.as(Employee_info_INjava.class);
	 System.out.println( javadata.getName()); 
	System.out.println( javadata.getLocation()); 
	System.out.println(javadata.getJob());
	System.out.println(javadata.getSalary());*/
	  
	  //****************************************************************************************
	  
	  Employee_info_INjava empobj=obj.readValue(empJson,Employee_info_INjava.class);
	  System.out.println("javadata");
	  System.out.println("***********************");
	  System.out.println(empobj.getName());
	  System.out.println(empobj.getSalary());
	  System.out.println(empobj.getLocation());
	  System.out.println(empobj.getJob());
}
}
