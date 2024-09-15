package DB_Connection2;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateUser_MAP {

	public static void main(String[] args) throws SQLException 
	{
		Map<String,Object> mp= new LinkedHashMap<String,Object>();
		mp.put("person ID", DB_connectionnn.getconnection(1));//  getconnection(int x)get from DB connection method name is a method to fatch value
		mp.put("LastName", DB_connectionnn.getconnection(2));
		mp.put("FirstName", DB_connectionnn.getconnection(3));
		mp.put("Address", DB_connectionnn.getconnection(4));
		mp.put("City", DB_connectionnn.getconnection(5));
		
		System.out.println(mp);
		
//request and response specification
		
	 RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://reqres.in").setContentType(ContentType.JSON).build();
	 RequestSpecification ress=given().log().all().spec(req);
	  ResponseSpecification resp= new ResponseSpecBuilder().build();
      String response= ress.when().post("api/users").then().log().all().spec(resp).extract().response().asString();
	
	 System.out.println(response);
		}

}

