package API_NonBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PATCH_RA007 {
	RequestSpecification r = RestAssured.given();
	Response re;
	ValidatableResponse vr;
	String baseURL = "https://restful-booker.herokuapp.com";
	String bookingId = "801";
	String basePath = "/booking"+"/"+bookingId;
	
	String token = "e119843b0abc485";
	String payload ="{\r\n"
			+ "    \"firstname\" : \"Pramod\"}";
	
	
	
	@Test
	public void patchRequestNonBDD() {
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON).log().all();
		r.cookie("token",token);
		r.body(payload);
		
		re = r.when().log().all().patch();
		String response=re.asString();
		System.out.println(response);
		
		vr = re.then();
		vr.statusCode(200);
		vr.body("firstname",Matchers.equalTo("Pramod"));
		vr.body("lastname",Matchers.equalTo("Brown"));
		
}
}
