package Demo;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

public class jiraAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="http://localhost:8080";
		
		// Login SCenarion
		SessionFilter session=new SessionFilter();
		String loginResponse=given().header("Content-Type","application/json").
		body("{\r\n" + 
				"  \"username\": \"avnees.bana001\",\r\n" + 
				"  \"password\": \"avnees.bana001\"\r\n" + 
				"}").log().all().filter(session).
		when().post("/rest/auth/1/session").
		then().log().all().extract().response().asString();
		System.out.println(loginResponse);

		// Add Comment
		given().pathParam("key", "10101").log().all().header("Content-Type","application/json").
		body("{\r\n" + 
				"    \"body\": \"Adding comment for issue 10026 on 25th August\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").filter(session).
		when().post("/rest/api/2/issue/{key}/comment").
		then().log().all().assertThat().statusCode(201);
		System.out.println("Comment has been successfully added.");
		
		
	}
}
