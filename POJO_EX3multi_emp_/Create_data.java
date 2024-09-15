package POJO_EX3multi_emp_;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Create_data {

	public static void main(String[] args) throws JsonProcessingException 
	
	{
		Pojo_java_data emp=new Pojo_java_data();
		emp.setJob("qa");
		emp.setLocation("kalanaur");
		emp.setName("ramanpreet kaur");
		emp.setSalary(3400);
		
		
		Pojo_java_data emp1=new Pojo_java_data();
		emp1.setJob("qa analyst");
		emp1.setLocation("banglore");
		emp1.setName("ramanpreet");
		emp1.setSalary(4400);;
		
		Pojo_java_data emp2=new Pojo_java_data();
		emp2.setJob("qa analyst");
		emp2.setLocation("banglore");
		emp2.setName("ramanpreet");
		emp2.setSalary(4400);
		
		List<Pojo_java_data> li=new ArrayList<Pojo_java_data>();
		li.add(emp2);
		li.add(emp1);
		li.add(emp);
		
		
            ObjectMapper obj=new ObjectMapper();
		
	    // it is a class that is going to 
		//help us to serialization the data and help us to provide functionality to read and writting json
		
	   String empJson=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(li);//change li inside writevalueasstring
	   
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
	  
	  
	  //deserialisation
	  
	  
	  Pojo_java_data empjava=obj.readValue(empJson,  Pojo_java_data.class);
	   System.out.println(empjava.getSalary());
	   System.out.println(empjava.getLocation());
	   System.out.println(empjava.getName());
	   System.out.println(empjava.getJob());
		
	}

}
