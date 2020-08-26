package Demo;

import org.testng.Assert;

import Utility.ReUsableJson;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String args[]) {
		
		
		JsonPath js=new JsonPath(ReUsableJson.coursePrice());
		
		// print the number of courses returned by API
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		// print purchase Amount
		int totalAmount=js.get("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		// print the title of the first course
		String firstCourseTitle=js.getString("courses[0].title");
		System.out.println(firstCourseTitle);
		
		// print all the courses titles and their respective prices
		
		for(int i=0;i<count;i++) {
			System.out.println(js.getString("courses["+i+"].title").toString());
			System.out.println(js.getString("courses["+i+"].price").toString());
		}
		
		// print the number of copies sold by RPA
		
		for(int i=0;i<count;i++) {
			String courseTitle=js.getString("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("RPA")) {
				int copyCount=js.getInt("courses["+i+"].copies");
				System.out.println("RPA copy count = "+copyCount);
				break;
			}
		}
		
		// verify if the sum of all the course price matches with purchase amount.
		
		int sum=0;
		for(int i=0;i<count;i++) {
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int total=(price*copies);
			System.out.println(total);
			sum=sum+total;
		}
		
		System.out.println("sum = "+sum);
		System.out.println("Purchase Amount = "+totalAmount);
		Assert.assertEquals(sum, totalAmount);
		System.out.println("Assertion has been passed. Sum of all the courses is equal to purchaseAmount.");
		
		}
}

