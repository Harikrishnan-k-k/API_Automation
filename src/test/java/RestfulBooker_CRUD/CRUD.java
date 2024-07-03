package RestfulBooker_CRUD;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;

public class CRUD {
	

	RequestSpecification r = RestAssured.given();
	Response re;
	ValidatableResponse vr;
	
	String baseURL = "https://restful-booker.herokuapp.com";
	String token;
	int bookingid;
	
	@BeforeTest
	public void getToken() {
		String basePath="/auth";
		String payload="{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON);
		r.body(payload);
		
		re=r.when().log().all().post();
		
		token=re.then().extract().path("token");
		Assert.assertNotNull(token);
		System.out.println(token);
		
		vr=re.then().log().all().statusCode(200);
		
	}
	
	@BeforeTest
	public void createBooking() {
		String basePath="/booking";
		String payload="{\r\n"
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
		
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON).log().all();
		r.body(payload);
		
		re=r.when().log().all().post();
		
		
		vr=re.then().log().all().statusCode(200);
		bookingid=re.then().extract().path("bookingid");
		
		
	}
	
	@Test
	public void updateBooking() {
		String basePath="/booking/"+bookingid;
		String payload="{\r\n"
				+ "    \"firstname\" : \"Pramod\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		r.baseUri(baseURL);
		r.basePath(basePath);
		r.contentType(ContentType.JSON);
		r.cookie("token",token);
		r.body(payload);
		
		re=r.when().log().all().put();
		String response=re.body().asPrettyString();
		System.out.println(response);
		
		JsonPath res = new JsonPath(response);
		String firstname = res.getString("firstname");
		String checkin = res.get("bookingdates.checkin");
		String lastname = re.then().extract().path("lastname");
		
		
		assertThat(firstname).isEqualTo("Pramod").isNotBlank();
		Assert.assertEquals(checkin, "2018-01-01");
		assertThat(lastname).isEqualTo("Brown").isNotBlank();
		
		
		
		vr=re.then().statusCode(200);
		vr.body("totalprice", Matchers.equalTo(111));
			
	}
	
	
}
	