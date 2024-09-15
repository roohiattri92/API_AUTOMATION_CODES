package Post_basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

import static io.restassured.RestAssured .*;

public class Json_body_passing {

	public static void main(String[] args) 
	{
	      Map<String,Object> mp=new LinkedHashMap<String, Object>();
	      mp.put("Name", "Ramanpreet");
	      mp.put("Last_name", "Kaur");
	      mp.put("age", "32");
	      
	      
	      
	      ArrayList<String> mp1=new ArrayList<String>();
	      mp1.add("cooking");
	      mp1.add("watching movie");
	      mp1.add("playing cricket");
	      
	      mp.put("hobbies", mp1);
	      
	      
	      Map<String,Object> mp2=new HashMap<String, Object>();
	      mp2.put("beautiful", "girl");
	      mp2.put("Handsome", "Man");
	      mp2.put("hardworking", "Mom");
	      mp2.put("landload", "Selfish");
	      
	      mp.put("Nature", mp2);
	      
	     RestAssured.baseURI="https://httpbin.org";
	     
	 String response=given().log().all().headers("Connection","keep-alive")
	     .body(mp)
	     .when().post("post")
	     .then().log().all().assertThat().statusCode(200)
	     .extract().response().asString();
	      
	      System.out.println(response);
	      }

}
