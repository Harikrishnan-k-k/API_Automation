package API_NonBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PUT_RA006 {
	
	RequestSpecification r = RestAssured.given();
	Response re;
	ValidatableResponse vr;
	String baseURL = "https://restful-booker.herokuapp.com";
	String bookingId = "801";
	String basePath = "/booking"+"/"+bookingId;
	
	String token = "e119843b0abc485";
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
	
	
	
	@Test
	public void putRequestNonBDD() {
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON).log().all();
		r.cookie("token",token);
		r.body(payload);
		
		re = r.when().log().all().put();
		String response=re.asString();
		System.out.println(response);
		
		vr = re.then();
		vr.statusCode(200);
		vr.body("firstname",Matchers.equalTo("Hari"));
		vr.body("lastname",Matchers.equalTo("Brown"));
		
		
	}

}
