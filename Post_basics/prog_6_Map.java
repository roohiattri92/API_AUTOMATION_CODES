package Post_basics;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

import static io.restassured.RestAssured .*;

public class prog_6_Map {

	public static void main(String[] args) 
	{
		
		Map<String,Object> mp=new LinkedHashMap<String,Object>();
		
		mp.put("Ramanpreet", "kaur");
		mp.put("Raman", "preet");
		mp.put("roohi", "kaur");
		
        Map<String,Object> mp1=new LinkedHashMap<String,Object>();
  
	    mp1.put("Ramanpreet1", "kaur1");
		mp1.put("Raman1", "preet1");
		mp1.put("roohi1", "kaur1");
		
		
		List<Map> li=new ArrayList<Map>();
		li.add(mp1);
		li.add(mp);
		
		
		
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all().headers("Content-Type","application/json")
		.body(li)
		
		.when().post("api/users/2")
		
		.then().log().all()
		.extract().response().asString();

	}

}
