package Assignment_2;

import static io.restassured.RestAssured.given;




import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class Validating_data1 {

	public static void main(String[] args)
	{
		
		
		String ID="bcd227";
		 String isbn="bcd";
		 String aisle="227";
		 String add=isbn+aisle;
		
         RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"bcd\",\r\n"
				+ "\"aisle\":\"227\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}")
		.when().post("/Library/Addbook.php/")
		.then().log().all().extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		
		String h=js.getString("Msg");
		System.out.println(h);
		String h1=js.getString("ID");
		System.out.println(h1);
		
		if(ID.contains("27"))
		{
			System.out.println("yes");
		}
		
		if(ID.equals(add))
		{
			System.out.println("Is equal to ID");
		}
		
		
		
		
		
		
		
		
		
		
		
		/*String obj=res.getHeader("content-type");
		System.out.println(obj);
		
		System.out.println("test case pass");
		
		
		ResponseBody k=	res.getBody();
	    System.out.println(k);
	    
	    
	    int k1=  res.getStatusCode();
	    System.out.println(k1);*/
	    }

}
