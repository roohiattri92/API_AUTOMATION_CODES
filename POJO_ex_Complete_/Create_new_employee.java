package POJO_ex_Complete_;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Create_new_employee {

	public static void main(String[] args) throws JsonProcessingException 
	{
		Employee_address_child empaddress= new Employee_address_child ();
		empaddress.setCity("Kalanaur");
		empaddress.setPincode(143512);
		empaddress.setState("punjab");
		empaddress.setStreet("nawakatra");
		
		
		Employee1Pojo_parents emp=new Employee1Pojo_parents();
		emp.setName("Harry");
		emp.setLocation("Delhi");
		emp.setSalary(50000f);
		emp.setJob("QA lead");
		emp.setEmpaddress(empaddress);
		
		ObjectMapper obj=new ObjectMapper();
		
	String empjson=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		
		RequestSpecification req= new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri("https://httpbin.org").build();
		
		RequestSpecification respec=given().log().all().spec(req).body(empjson);
		
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).build();
		
		
	Response response=	respec.when().post("post").then().log().all().spec(res)
		.extract().response();
	
	
String jsonresponse= response.asString();
System.out.println(response);
System.out.println(jsonresponse);


//deserialization


Employee1Pojo_parents empobj=obj.readValue(empjson, Employee1Pojo_parents.class);



System.out.println(empobj.getEmpaddress()	);
System.out.println(empobj.getJob());
System.out.println(empobj.getLocation());
System.out.println(empobj.getName());
System.out.println(empobj.getSalary());
		
		
		
Employee_address_child empaddress1=obj.readValue(empjson, Employee_address_child.class);
System.out.println(empaddress1.getCity());
System.out.println(empaddress1.getPincode());
System.out.println(empaddress1.getState());
System.out.println(empaddress1.getStreet());

		
	}

}
