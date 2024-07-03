package ATB6x.API;

import io.restassured.RestAssured;

public class RA001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/ping")
		.when().log().all().get().then().log().all().statusCode(201);
		

	}

}
