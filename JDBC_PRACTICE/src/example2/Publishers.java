package example2;

public class Publishers {
	private int publisher_id;
	private String name;
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publishers(int publisher_id, String name) {
		super();
		this.publisher_id = publisher_id;
		this.name = name;
	}
	public Publishers() {
	}
	
	
}
