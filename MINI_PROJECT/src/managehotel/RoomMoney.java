package managehotel;

public class RoomMoney {
	private String booking_ID;
	private int roomMoney;
	private String Identity;
	public String getBooking_ID() {
		return booking_ID;
	}
	public void setBooking_ID(String booking_ID) {
		this.booking_ID = booking_ID;
	}
	public int getRoomMoney() {
		return roomMoney;
	}
	public void setRoomMoney(int roomMoney) {
		this.roomMoney = roomMoney;
	}
	public String getIdentity() {
		return Identity;
	}
	public void setIdentity(String identity) {
		Identity = identity;
	}
	public RoomMoney(String booking_ID, int roomMoney, String identity) {
		super();
		this.booking_ID = booking_ID;
		this.roomMoney = roomMoney;
		Identity = identity;
	}
	public RoomMoney() {
		super();
	}

	
	
}
