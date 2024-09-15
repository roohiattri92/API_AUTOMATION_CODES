package MiscConcepts;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class Session_filter 
{
	SessionFilter s;
	
	@BeforeSuite
	public SessionFilter prereq()
	{
		SessionFilter s=new SessionFilter();//can use same in all test cases
		return s;
		
		}
	
	
	@Test
	public void display()
	{
		//SessionFilter f=new SessionFilter();
		RestAssured.baseURI="https://httpbin.org";
		HashMap<String,Object> mp= new LinkedHashMap<String,Object>();
		mp.put("Name","Tom");
		mp.put("age",35);
		mp.put("last name","kaur");
		mp.put("Is married", true);
		
		String response= given().log().all().filter(s)
		.headers("Connection","keep-alive").body(mp)
		.when().post("post")
		.then().log().all().extract().response().asString();
		System.out.println(response);
}
	
	@Test
	public void usedata()
	{
		
	}


	}


