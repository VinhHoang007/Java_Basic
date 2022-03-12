package managehotel;

public class Customer {
	private String customer_id;
	private String identity;
	private String fullName;
	private String phone;
	private String address;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(String customer_id, String identity, String fullName, String phone, String address) {
		this.customer_id = customer_id;
		this.identity = identity;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
	}
	public Customer(String identity, String fullName, String phone, String address) {
		this.identity = identity;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
	}
	public Customer() {
		super();
	}
	
	
}
