package Excel_IntegrationRestAssured;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import constant.Constant_Excel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Create_user_throEXCEL {

	public static void main(String[] args) throws IOException
	{
		FetachdatafromEXCEL G= new FetachdatafromEXCEL(Constant_Excel.excel_file,Constant_Excel.sheet_name);
		RestAssured.baseURI="https://reqres.in";
		
		Map<String,Object> mp= new LinkedHashMap<String,Object>();
		mp.put("FirstName", FetachdatafromEXCEL.getdatafrom_Excel(1, 0));
		mp.put("LastName", FetachdatafromEXCEL.getdatafrom_Excel(1, 1));
		mp.put("ID", FetachdatafromEXCEL.getdatafrom_Excel(1, 2));
		
		
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://reqres.in").setContentType(ContentType.JSON).build();
		 RequestSpecification ress=given().log().all().body(mp).spec(req);
		  ResponseSpecification resp= new ResponseSpecBuilder().build();
	      String response= ress.when().post("api/users").then().log().all().spec(resp).extract().response().asString();
		
		 System.out.println(response);
			}
	}


