package API_NonBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DELETE_RA008 {
	RequestSpecification r = RestAssured.given();
	Response re;
	ValidatableResponse vr;
	String baseURL = "https://restful-booker.herokuapp.com";
	String bookingId = "801";
	String basePath = "/booking"+"/"+bookingId;
	
	String token = "e119843b0abc485";
	
	
	
	
	@Test
	public void deleteRequestNonBDD() {
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON).log().all();
		r.cookie("token",token);
		
		re = r.when().log().all().delete();
		String response=re.asString();
		System.out.println(response);
		
		vr = re.then();
		vr.statusCode(201);
		
		
}
}
