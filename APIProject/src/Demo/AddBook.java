package Demo;

import org.testng.annotations.Test;

import Utility.ReUsableJson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBook {

	@Test
	public void addNewBook() {
		
		RestAssured.baseURI="http://216.10.245.166";
		String response= given().header("Content-Type","application/json").body(ReUsableJson.addBook("bcd2","54112")).
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReUsableJson.rawToJson(response);
		String responseID=js.get("ID");
		System.out.println(responseID);
	}
}
