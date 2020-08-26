package Utility;

import io.restassured.path.json.JsonPath;

public class ReUsableJson {
	
	public static JsonPath rawToJson(String response) {
		JsonPath js1=new JsonPath(response);
		return js1;
	}

	
	public static String coursePrice() {
		return "{\r\n" + 
				"   \"dashboard\": {\r\n" + 
				"      \"purchaseAmount\": 910,\r\n" + 
				"      \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"   },\r\n" + 
				"   \"courses\": [\r\n" + 
				"      {\r\n" + 
				"         \"title\": \"Selenium Python\",\r\n" + 
				"         \"price\": 50,\r\n" + 
				"         \"copies\": 6\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"title\": \"Cypress\",\r\n" + 
				"         \"price\": 40,\r\n" + 
				"         \"copies\": 4\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"title\": \"RPA\",\r\n" + 
				"         \"price\": 45,\r\n" + 
				"         \"copies\": 10\r\n" + 
				"      }\r\n" + 
				"   ]\r\n" + 
				"}";
	}
	
	public static String addBook(String isbn, String aisle) {
		String addBookString= "{\r\n" + 
				"\"name\":\"My Book1\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe1\"\r\n" + 
				"}";
		return addBookString;
	}
	
	public static String deleteBook(String id) {
		String deleteBookString ="{\r\n" + 
				" \"ID\" : \""+id+"\"\r\n" + 
				" } "; 
		return deleteBookString;
	}
	
}
