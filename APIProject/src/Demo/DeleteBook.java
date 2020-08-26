package Demo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteBook {
	
	@Test
	public void deleteNewBook() {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		given().log().all().header("Content-Type","text/plain").
		body("{\r\n" + 
				" \"ID\" : \"bcd254112\"\r\n" + 
				" } \r\n" + 
				"").
		when().delete("/Library/DeleteBook.php").
		then().log().all().assertThat().statusCode(200).body("msg",equalTo("book is successfully deleted"));
		
		System.out.println("Book has been successfully deleted.");
		
		
	}

}
