package DataLoading;

import java.util.Map;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DataLoading {
	
	
	String baseURL = "https://restful-booker.herokuapp.com";
	//String bookingId = "4192";
	String basePath = "/booking";
	
	String token = "7ca0bc7af361f5a";
	
	@Test
	public void dataLoading() {
		
		Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
		Faker f = new Faker();
		
		jsonBodyUsingMap.put("firstname", f.name().firstName());
		jsonBodyUsingMap.put("lastname", f.name().lastName());
		jsonBodyUsingMap.put("totalprice", f.random().nextInt(1000));
		jsonBodyUsingMap.put("depositpaid", f.random().nextBoolean());
		
		Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2018-01-05");
        
        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        
        RequestSpecification r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON).log().all();
		r.body(jsonBodyUsingMap);
		
		Response res = r.when().log().all().post();
		String response=res.asString();
		System.out.println(response);
		
		ValidatableResponse vr = res.then();
		vr.statusCode(200);
		
		
		
	}

}
