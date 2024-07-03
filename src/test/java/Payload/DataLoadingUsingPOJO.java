package Payload;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DataLoadingUsingPOJO {
	@Test
	public void postRequestNonBDD() {
		
		Faker f = new Faker();
		
		
		String baseURL = "https://restful-booker.herokuapp.com";
		String basePath = "/booking";
		
		Booking b = new Booking();
		b.setFirstname(f.name().firstName());
		b.setLastname(f.name().lastName());
		b.setTotalprice(f.random().nextInt(1000));
		b.setDepositpaid(f.random().nextBoolean());
		
		Bookingdates bd = new Bookingdates();
		bd.setCheckin("2018-01-01");
		bd.setCheckout("2019-01-01");
		b.setBookingdates(bd);
		
		b.setAdditionalneeds("breakfast");
		
		System.out.println(b.toString());
		
		RequestSpecification r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON).log().all();
		r.body(b);
		
		Response res = r.when().log().all().post();
		String response=res.asString();
		System.out.println(response);
		
		ValidatableResponse vr = res.then();
		vr.statusCode(200);

		
}

}
