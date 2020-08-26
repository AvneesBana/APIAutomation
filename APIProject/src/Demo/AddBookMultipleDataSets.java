package Demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ReUsableJson;

public class AddBookMultipleDataSets {
	
	@Test(dataProvider = "ApiParameter")
	public void addBookMethod(String isbn, String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String resp=given().header("Content-Type","application/json").body(ReUsableJson.addBook(isbn, aisle)).
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=ReUsableJson.rawToJson(resp); 
		String id=js.get("ID");
		System.out.println(id);
	}
	
	@DataProvider(name="ApiParameter")
	public Object[][] getData(){
		return new Object[][] {
				{"bcd2","54112"},
				{"bcd3","54113"},
				{"bcd4","54114"}
		};
	}

}
