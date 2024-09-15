 /* 1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount*/

package Mockvalidation;

import org.testng.Assert;

import Payloads.Mock_payload;
import io.restassured.path.json.JsonPath;

public class Mock_validatation {

	public static void main(String[] args) 
	{
		//Print Title of the first course
		JsonPath js=new JsonPath(Mock_payload.mock_val());
		String course_title=js.getString("courses[0].title");
		System.out.println(course_title);
		
		String Size=js.getString("courses.size()");
		System.out.println(Size);
		
		//2.Print Purchase Amount
		String purchaseamount=js.getString("dashboard.purchaseAmount");
		System.out.println(purchaseamount);
		
		//3. Print Title of the second course
		
		String secondcourse=js.getString("courses[1].title");
		System.out.println(secondcourse);
		
		//Print All course titles and their respective Prices
		
		
		for(int i=0;i<3;i++)
		{
			String Totalcourse=js.getString("courses["+i+"].title");
			System.out.println(Totalcourse);
			
			String total_prices=js.getString("courses["+i+"].price");
			System.out.println(total_prices);
		}
		
		//5. Print no of copies sold by RPA Course
		
		String courseRpa_copies=js.getString("courses[2].copies");
		System.out.println(courseRpa_copies);
		
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount*/
         int sum=0;
		for(int i=0;i<3;i++)
		{
		
		int  prices1=js.getInt("courses["+i+"].price");
		
		int prices2=js.getInt("courses["+i+"].copies");
		
     	int r=	prices1*prices2;
     	
         sum=r+sum;
        }
		
        System.out.println(sum);
         
       Assert.assertEquals(sum,purchaseamount );
       
       System.out.println("test case is pass");

	}

}
