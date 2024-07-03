package Payload;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class Serialization {
	
	Faker f = new Faker();
	Booking b = new Booking();
	Bookingdates bd = new Bookingdates();
	
	@Test
	public void gsonTest() {
		
		
		
		b.setFirstname(f.name().firstName());
		b.setLastname(f.name().lastName());
		b.setTotalprice(f.random().nextInt(1000));
		b.setDepositpaid(f.random().nextBoolean());
		
		
		bd.setCheckin("2018-01-01");
		bd.setCheckout("2019-01-01");
		b.setBookingdates(bd);
		
		b.setAdditionalneeds("breakfast");
	System.out.println(b.toString());
	
	Gson g = new Gson();
	String jsonString = g.toJson(b);
	System.out.println(jsonString);
	}
 
	@Test
	public void jacksonTest() throws JsonProcessingException {
		
		
		
		b.setFirstname(f.name().firstName());
		b.setLastname(f.name().lastName());
		b.setTotalprice(f.random().nextInt(1000));
		b.setDepositpaid(f.random().nextBoolean());
		
		
		bd.setCheckin("2018-01-01");
		bd.setCheckout("2019-01-01");
		b.setBookingdates(bd);
		
		b.setAdditionalneeds("breakfast");
	System.out.println(b.toString());
	
	ObjectMapper o = new ObjectMapper();
	String jsonString = o.writerWithDefaultPrettyPrinter().writeValueAsString(b);
	System.out.println(jsonString);
	
	}
}
