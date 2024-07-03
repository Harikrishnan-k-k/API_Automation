package API_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POST_RA004 {
	@Test
	public void putRequestBDD() {
		
		String baseURL = "https://restful-booker.herokuapp.com";
		String basePath = "/booking";
		String payload ="{\r\n"
				+ "    \"firstname\" : \"Hari\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		RestAssured.given().baseUri(baseURL).basePath(basePath).contentType(ContentType.JSON).log().all().body(payload)
		.when().post().then().log().all().statusCode(200);
	}

}
