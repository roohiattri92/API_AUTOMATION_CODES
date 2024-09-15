package Assignment_2;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Assignment_get {

	public static void main(String[] args) 
	{
		 RestAssured.baseURI="http://216.10.245.166";
			
			String response=given().log().all()
	    	.queryParam("AuthorName", "john").header("Content-Type","application/json")
			
	        .when().get("/Library/GetBook.php")
			.then().log().all().extract().response().asString();
			
			System.out.println(response);
			
		JsonPath js=new JsonPath(response);
	     String h=js.getString("book_name");
	     System.out.println(h);
	     String h1=js.getString("isbn");
	     System.out.println(h1);
	     
}

}
