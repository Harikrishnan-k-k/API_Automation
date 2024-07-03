package API_BDD;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;

public class Get_RA002 {
	@Description("Verify GET Request")
	@Test
	public void getRequest() {
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/ping")
		.when().log().all().get().then().log().all().statusCode(201);
		
	}

}
