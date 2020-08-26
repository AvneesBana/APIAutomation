package Demo;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Utility.Payload;
import Utility.ReUsableJson;

public class BasicsAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Adding the place
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=
		given().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body(Payload.addPlace()).
		when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		
		JsonPath js=ReUsableJson.rawToJson(response);
		
		String placeId=js.get("place_id");
		System.out.println(placeId);
		
		// Updating the place
		
		String newAddress="winter walk, USA";
		given().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"").
		when().put("/maps/api/place/update/json").
		then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		System.out.println("Address updated successfully");
		
		
		// Get the place
		
		String getPlaceResponse=given().queryParam("key", "qaclick123").queryParam("place_id", placeId).
		when().get("/maps/api/place/get/json").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = ReUsableJson.rawToJson(getPlaceResponse);
		
		String updatedAddress=js1.getString("address");
		System.out.println("New Address updated ="+updatedAddress);
		
		Assert.assertEquals(updatedAddress, newAddress);
		System.out.println("Assertion successfully passed.");
		
		
		
	}

}
