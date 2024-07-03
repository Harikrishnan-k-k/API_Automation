package Payload;

public class BookingResponse {

	String bookingid ;
	Booking booking;
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	@Override
	public String toString() {
		return "BookingResponse [bookingid=" + bookingid + ", booking=" + booking + "]";
	}
	
}
