package Json_javaScriptObjectNotation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import io.restassured.RestAssured;

public class passing_json_payload {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://httpbin.org";
		HashMap<String,Object> mp= new LinkedHashMap<String,Object>();
		mp.put("Name","Tom");
		mp.put("age",35);
		mp.put("last name","kaur");
		mp.put("Is married", true);
		
		ArrayList<String> mp1=new ArrayList<String>();
		mp1.add("cricket");
		mp1.add("footbal");
		mp1.add("cooking");
		mp.put("hobbies", mp1);
		
		
		HashMap<String,	String> mp2= new LinkedHashMap<String,String>();
		mp2.put("Programming language","java");
		mp2.put("Webapplication","selenium");
		mp2.put("Automation testing","rest assured");
		
		mp.put("Skill", mp2);
		
		String response= given().log().all().headers("Connection","keep-alive").body(mp)
		.when().post("post")
		.then().log().all().extract().response().asString();
		System.out.println(response);
}
}
