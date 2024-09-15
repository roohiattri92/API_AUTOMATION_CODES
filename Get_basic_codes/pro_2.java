package Get_basic_codes;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class pro_2 {

	public static void main(String[] args) {
		// validating of body
		
				RestAssured.baseURI="https://reqres.in/";//1
				
				String response= given().log().all().header("Connection","keep-alive")// 2
				.when().get("api/users/2")
				.then().log().all().assertThat().statusCode(200)
				.body("data.first_name",equalTo("Janet") )
				.body("data.last_name", equalTo("Weaver"))
				.body("data.email", equalTo("janet.weaver@reqres.in"))
				.header("Server", "cloudflare")
				//.header("Age", "3197")
				.extract().response().asString();
				
				System.out.println(response);
				
				System.out.println("Test case is pass");
				

			}

		}