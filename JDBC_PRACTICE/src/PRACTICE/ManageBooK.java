package PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ManageBooK {

	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName =EBOOK_SHOP;";
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static Scanner sc = new Scanner(System.in);
	static EBOOK eb = new EBOOK();
	
	public static void menu() {
		System.out.println("========================= CHUONG TRINH QUAN LY SACH =========================");
		System.out.println();
		System.out.println("                         1. Thêm Sách");
		System.out.println("                         2. Cập Nhật Sách Theo ID");
		System.out.println("                         3. Cập Nhật Sách Theo Title");
		System.out.println("                         4. Tìm Kiếm Sách Theo Title ");
		System.out.println("                         5. Tìm Sách Theo Author");
		System.out.println("                         6. Tìm Kiếm Sách Theo PRICE");
		System.out.println("                         7. Cập Nhật Giá Sách");
		System.out.println("                         8. Sắp Xếp Sách Theo Giá Tăng Dần");
		System.out.println("                         9. Sắp Xếp Sách Theo Qty Giảm Dần");
		System.out.println("                        10. Hien Thi Toan Bo Thông Tin Sach");
		System.out.println("                        11. Quit");
		System.out.println("Nhập Lựa Chọn Của Bạn");
	}
	public static void manageBook(Connection conn,int key) {
		
		switch (key) {
			case 1:
				eb.insertBook(conn);
				break;
			case 2:
				eb.updateBookID(conn);
				break;
			case 3:
				eb.updateBookTitle(conn);
				break;				
			case 4:
				eb.selectBookTitle(conn);
				break;
			case 5:
				eb.selectBookAuthor(conn);
				break;
			case 6:
				eb.selectBookPrice(conn);
				break;
			case 7:
				eb.updatePrice50(conn);
				break;
			case 8:
				eb.selectBookQtyeDsc(conn);
				break;
			case 9:
				eb.selectBookQtyeDsc(conn);
				break;
			case 10:
				eb.selectBookAll(conn);
				break;
			case 11:
				System.out.println("Ket Thuc Chuong Trinh");
				break;
			default:
				System.out.print("Đầu Vào Không Hợp Lệ!!!");
				break;
		}
	}
	public static void main(String[] args) {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database ...");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			int key;
			do {
				menu();
				key = sc.nextInt();
				manageBook(conn,key);
			} while (!"11".equalsIgnoreCase(String.valueOf(key)));
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
