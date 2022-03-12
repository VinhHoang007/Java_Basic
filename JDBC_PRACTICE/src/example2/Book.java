package example2;

public class Book {
	
	private int book_id;
	private String title;
	private int total_pages;
	private float rating;
	private String isbn;
	private String publishered_date;
	private int publisher_id;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublishered_date() {
		return publishered_date;
	}
	public void setPublishered_date(String publishered_date) {
		this.publishered_date = publishered_date;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public Book(int book_id, String title, int total_pages, float rating, String isbn, String publishered_date,
			int publisher_id) {
		this.book_id = book_id;
		this.title = title;
		this.total_pages = total_pages;
		this.rating = rating;
		this.isbn = isbn;
		this.publishered_date = publishered_date;
		this.publisher_id = publisher_id;
	}
	public Book() {
	}
	
	
}
