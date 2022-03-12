package managehotel;

public class ServiceMoney {
	private String booking_ID;
	private int serviceMoney;
	public String getBooking_ID() {
		return booking_ID;
	}
	public void setBooking_ID(String booking_ID) {
		this.booking_ID = booking_ID;
	}
	public int getServiceMoney() {
		return serviceMoney;
	}
	public void setServiceMoney(int serviceMoney) {
		this.serviceMoney = serviceMoney;
	}
	public ServiceMoney(String booking_ID, int serviceMoney) {
		super();
		this.booking_ID = booking_ID;
		this.serviceMoney = serviceMoney;
	}
	public ServiceMoney() {
		super();
	}
	
}
