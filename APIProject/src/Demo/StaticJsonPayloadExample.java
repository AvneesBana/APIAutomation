package Demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Utility.ReUsableJson;

public class StaticJsonPayloadExample {

	@Test
	public void addBook() throws IOException {
		RestAssured.baseURI="http://216.10.245.166";
		String resp =given().log().all().header("Content-Type","application/json").body(GenerateStringFromSource("C:\\Users\\my pc\\Desktop\\Json\\Addbookdetail.json")).
				when().post("/Library/Addbook.php").
				then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReUsableJson.rawToJson(resp);
		String id=js.get("ID");
		System.out.println(id);
	}
	
	public static String GenerateStringFromSource(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	
	
}
