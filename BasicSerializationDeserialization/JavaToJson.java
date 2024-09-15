package BasicSerializationDeserialization;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.minidev.json.JSONObject;

public class JavaToJson //need to check deserialization not worked
{
	@Test
    public void Jsonconvert()
    {
	JSONObject payload= new JSONObject();// like map we can use JSONObject it consume less memory.
	payload.put("name","harry");
	payload.put("job", "QA");
	payload.put("id", 12);
	
	RestAssured.baseURI="https://reqres.in/";
	
	Response res=given().log().all().body(payload.toJSONString())//In the form of Json 
	.header("content-type","application/json")
	.when().post("api/users")
	.then().log().all().extract().response();
	
	System.out.println("the json response ");
    System.out.println(res);
    
   String responsecode=res.asString();//in the form of String
    System.out.println(responsecode);
    
    
    String y=res.getHeader("server");
	System.out.println(y);
	
	
	int statuscode=res.getStatusCode();
	System.out.println(statuscode);
	
    ResponseBody obj=res.getBody();// Response body we use to get response data
                                    //in the form of json not in the form of string
	System.out.println(obj);
	
	
	
	Java_Data jdata=obj.as(Java_Data.class);	//deserialization   //Java_Data it is class name of java where we created data
	String name=jdata.name;
	String age=jdata.job;
	int Id=jdata.Id;
	System.out.println(name);
	System.out.println(age);
	System.out.println(Id);
	
	Assert.assertEquals("harry", name,"Validating name");
	}
}
