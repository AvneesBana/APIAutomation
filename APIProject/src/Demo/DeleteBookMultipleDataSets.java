package Demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ReUsableJson;

public class DeleteBookMultipleDataSets {
	
	@Test(dataProvider = "deleteApi")
	public void deleteBookMethod(String id) {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String resp=given().header("Content-Type","text/plain").body(ReUsableJson.deleteBook(id)).
		when().post("/Library/DeleteBook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=ReUsableJson.rawToJson(resp);
		String message=js.get("msg");
		System.out.println(message);
	}
	
	@DataProvider(name="deleteApi")
	public Object[][] getData(){
		return new Object[][] {
				{"bcd254112"},
				{"bcd354113"},
				{"bcd454114"}
		};
	}
}
