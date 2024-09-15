package POJOEX4;

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

public class Create_data_pojo {

	public static void main(String[] args) throws JsonProcessingException 
	{
		Java_data1CHILD empadd= new Java_data1CHILD();
		empadd.setCity("kalanaur");
		empadd.setPincode(145423);
		empadd.setState("punjab");
		empadd.setStreet("parkside");
		
		List <String> bank=new ArrayList<String>();
		bank.add("SBI");
		bank.add("HDFC");
		bank.add("YES BANK");
		
		Javadata_parents empdetail=new Javadata_parents();
		empdetail.setJob("qa");
		empdetail.setLocation("banglore");
		empdetail.setName("ramanpreet");
		empdetail.setSalary("356868");
		empdetail.setEmpaddress(empadd);
		empdetail.setBank(bank);
		
		
	ObjectMapper obj=new ObjectMapper();
	
	String EmpJson=obj.writerWithDefaultPrettyPrinter().writeValueAsString(empdetail);
	
	
	
	
	RequestSpecification req=new RequestSpecBuilder()
	.setContentType(ContentType.JSON).setBaseUri("https://httpbin.org").build();
	
	RequestSpecification respec=given().log().all().spec(req);
	ResponseSpecification response=new ResponseSpecBuilder()
	.expectContentType(ContentType.JSON).expectStatusCode(200).build();
	
	Response Response1=respec.when().post("post").then().log().all().extract().response();
	  String responses= Response1.asString();
	  
	  System.out.println(responses);
	  
	  
	  Javadata_parents conv_javadata=obj.readValue(EmpJson, Javadata_parents.class);
	System.out.println(  conv_javadata.getBank());
	System.out.println(  conv_javadata.getJob());
	System.out.println(  conv_javadata.getLocation());
	System.out.println(  conv_javadata.getSalary());
	System.out.println(  conv_javadata.getName());
	System.out.println(  conv_javadata.getEmpaddress());
	  
	  
	  Java_data1CHILD  conv_Javadata1=obj.readValue(EmpJson, Java_data1CHILD.class);
	  
	  System.out.println(conv_Javadata1.getCity());
	  System.out.println(conv_Javadata1.getPincode());
	  System.out.println(conv_Javadata1.getState());
	
	  System.out.println(conv_Javadata1.getStreet());
	  
	}

}
