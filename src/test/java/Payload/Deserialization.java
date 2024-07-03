package Payload;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Deserialization {
	
	String jsonString = "{\r\n"
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
	public void gsonTest() {
	

        Gson g = new Gson();
        Booking b = g.fromJson(jsonString,Booking.class);
        System.out.println(b.toString());
		
	}
	
	@Test
	public void jacksonTest() throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper o = new ObjectMapper();
		Booking b = o.readValue(jsonString,Booking.class);
		System.out.println(b.toString());
	}
}
