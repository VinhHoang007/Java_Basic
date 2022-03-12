package ASSIGNMENT_DAY14;

import java.util.Scanner;
import java.sql.*;

public class Assignment14 {
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName =ManagerEmployee;";
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";
	static Connection conn = null;
	static Scanner sc = new Scanner(System.in);

	public static void manageProgram() {
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
			System.out.println();
			System.out.println("            Bạn Muốn Chọn Mục Nào?");
			System.out.print("....");
			n = sc.nextInt();
			
		} while (!(n >= 1 && n <= 5));
		ManageEmployee mana = new ManageEmployee();
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database ...");
			conn =  DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
		}

		switch (n) {
		case 1:
			mana.selectAllEmployee(conn);
			break;
		case 2:
			mana.findEmployee(conn);
			break;
		case 3:
			mana.updateEmployee(conn);
			break;
		case 4:
			mana.insertEmployee(conn);
			break;
		case 5:
			mana.deleteEmployee(conn);
			break;
		default:
			System.out.println("Dau Vao Khong Hop Le!!!");
			break;
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String chose = "";
		do {
			
			manageProgram();
			System.out.println("Ban Co Muon Su Dung Tiep Chuong Trinh? Y/N");
			chose = sc.next();
		} while ("Y".equalsIgnoreCase(chose));
		System.out.println("Chuong Trinh Ket Thuc");
		
	}
}
