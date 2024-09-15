package Auth_basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Auth_2_0 {
	 String Access_Token;
	
     @Test(priority=-1)
	public void getaccess_Token()
	{
		
		String Client_ID="AcCpJiWpYCOuyWTrbo0XW36uRTA2TgiT4kL7j3BwKFvk7MTfnvreGXQAyc-m4HBUAI6fVMiHeCMckKxJ";
		String ClientSecreatID="EDaACJrx6_6ShGVIv85A9ThMfHLYGPkH5zrEGH5Fyl3SRKhxubVISD-LsrgpGtK-1yAUqVyEco0_TDbC";
		
	
	    RestAssured.baseURI="https://api-m.sandbox.paypal.com";
	
	    String Response= given().auth().preemptive().basic(Client_ID, ClientSecreatID)
	    .param("grant_type", "client_credentials")
	    .when().post("v1/oauth2/token")
	
	    .then().log().all().extract().response().asString();
	
	     System.out.println(Response);
	     
	     JsonPath js= new JsonPath(Response);
	     
	   Access_Token= js.getString("access_token");
	    System.out.println(Access_Token);
}
     
     
     @Test
     public void accessResourceserver()
     {
    	 
    	 RestAssured.baseURI="https://api-m.sandbox.paypal.com";
    	String response= given().log().all().queryParam("page", 3).queryParam("page_size", 4)
    	.queryParam("total_count_required", "true")
    	.auth().oauth2(Access_Token)
    	.when().get("v1/invoicing/invoices")
    	.then().log().all().extract().response().asString();
    	System.out.println(response);
 }
	

}



