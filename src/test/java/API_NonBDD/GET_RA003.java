package API_NonBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
@Test
public class GET_RA003 {
	public void getRequestNonBDD() {
		RequestSpecification r = RestAssured.given();
		r.baseUri("https://api.zippopotam.us");
		r.basePath("/in/383001");
		r.when().log().all().get();
		r.then().log().all().statusCode(200);
	}

}
