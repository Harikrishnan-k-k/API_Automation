package API_NonBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_RA005 {
	@Test
	public void postRequestNonBDD() {
		
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
	
		RequestSpecification r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON).log().all();
		r.body(payload);
		
		Response res = r.when().log().all().post();
		String response=res.asString();
		System.out.println(response);
		
		ValidatableResponse vr = res.then();
		vr.statusCode(200);

}
}
