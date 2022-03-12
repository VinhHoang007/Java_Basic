package day14_version2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ASSIGNMENT_DAY14.Employee;

public class process {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName =ManagerEmployee;";

	// User and password
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";

	public static int menu(Scanner sc) {
		int n;

		do {
			System.out.println("----------------CHUONG TRINH QUAN LY NHAN VIEN----------------");
			System.out.println();

			System.out.println();
			System.out.println("            1. Hiển Thị Thông Tin Toàn Bộ Nhân Viên");
			System.out.println("            2. Tìm Kiếm Nhân Viên Theo Tên");
			System.out.println("            3. Cập Nhật Thông Tin Nhân Viên");
			System.out.println("            4. Thêm Thông Tin Nhân Viên");
			System.out.println("            5. Xóa Thông Tin Nhân Viên");
			System.out.println("            6. Thoát");
			System.out.println();
			System.out.println("            Bạn Muốn Chọn Mục Nào?");
			System.out.print("....");
			n = Integer.parseInt(sc.nextLine());

		} while (!(n >= 1 && n <= 6));
		return n;
	}

	public static int program(int n, Scanner sc, Connection conn, PreparedStatement pstmt) {
		
		Methods mt = new Methods();
		try {

			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database ...");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	
			switch (n) {
			case 1:
//				selectAllEmployee(conn,sc);
				ArrayList<Employee> list = mt.getDB(conn, pstmt);
				mt.printListDB(list);
				break;
			case 2:
				ArrayList<Employee> listSearch = mt.getDB(conn,pstmt);
				mt.search(listSearch, sc,pstmt);
//				searchEmployee(conn,sc);
				break;
			case 3:
				mt.updateEmployee(conn, sc,pstmt);
				break;
			case 4:
				mt.insertEmployee(conn, pstmt,sc);
				break;
			case 5:
				mt.deleteEmployee(conn,pstmt, sc);
				break;
			case 6:
				System.out.println("Chuong Trinh Ket Thuc");
				break;

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return n;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n;
		do {
			n = menu(sc);
			program(n, sc,conn,pstmt);

		} while (!"6".equalsIgnoreCase(String.valueOf(n)));

		sc.close();
	}

}
