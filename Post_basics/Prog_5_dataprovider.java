package Post_basics;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Payloads.Payload2_dp;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Prog_5_dataprovider
{
	@Test(dataProvider="worldbook")
	public void postdata( String isbn,String aisle)
	{
		String actual_id="Book Already Exists";
	
	    RestAssured.baseURI="http://216.10.245.166";
		
	    String response=given().log().all().headers("Connection","Keep-Alive")
		.body(Payload2_dp.dataprovider_input( isbn,aisle))
		
		.when().post("ibrary/Addbook.php")
		
		.then().log().all().extract()
		
		.response().asString();
		

		JsonPath js=new JsonPath(response);
		String expected_id=js.getString("Msg");
		
		Assert.assertEquals(actual_id, expected_id);
		System.out.println("*********** Test case is pass ***********");
		
		}

      @DataProvider(name="worldbook")
     public Object[][]multiple_input()
{
	
    	  {
    			return new Object[][]
    					{
    				{"qqweqwe","123221"},
    				{"yqqqwieuy","23123"}
    				
    					};
    	  }
}
}
    		

		
	
	
	
	
	
	
	
	
	
	
	
	
	















	
