package example2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Process {
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName = ManageBook;";
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";


	public static int menu(Scanner sc) {
		int n;
		do {
			System.out.println("==================== CHUONG TRINH QUAN LY SACH ====================");
			System.out.println();
			System.out.println(" 1. Liet Ke Sach Theo Title");
			System.out.println(" 2. Liet Ke Sach Theo Publisher_name");
			System.out.println(" 3. Liet ke Sach Theo Title Va Publishers_name");
			System.out.println(" 4. Liet ke Sach co total_pages < k");
			System.out.println(" 5. Liet ke Publishers cung viet book ma title co chu \"ABC\" ");
			System.out.println(" 6. Liet ke Sach rating tu x tro len");
			System.out.println(" 7. Liet ke Sach published_date truoc ngay xx/yy/zzzz");
			System.out.println(
					" 8. Dem Sach dc viet boi publishers_name trong khoang thoi gian tu aa/bb/cccc den xx/yy/zzzz");
			System.out.println(" 9. Them sach");
			System.out.println("10. Them publiser_name");
			System.out.println("11. Quit");
			System.out.println();
			System.out.print("Nhap su lua chon cua ban:");
			n = Integer.parseInt(sc.nextLine());
		} while (!(n >= 1 && n <= 11));

		return n;

	}

	public static void manage(Scanner sc, Connection conn, PreparedStatement pstmt, int key) {
		Methods mt = new Methods();
		switch (key) {
		case 1:
			mt.selectBook1(conn, sc, pstmt);
			break;
		case 2:
			mt.selectBook2(conn, sc, pstmt);
			break;
		case 3:
			mt.selectBook3(conn, sc, pstmt);
			break;
		case 4:
			mt.selectBook4(conn, pstmt);
			break;
		case 5:
			mt.selectBook5(conn, sc, pstmt);
			break;
		case 6:
			mt.selectBook6(conn, sc, pstmt);
			break;
		case 7:
			mt.selectBook7(conn, sc, pstmt);
			break;
		case 8:
			mt.selectBook8(conn, sc, pstmt);
			break;
		case 9:
			mt.insertBook(sc, conn, pstmt);
			break;
		case 10:
			mt.insertPublisher(sc, conn, pstmt);
			break;	
		case 11:
			System.out.println("Chuong trinh ket thuc");
			break;
		}
	}

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database ...");

			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			Scanner sc = new Scanner(System.in);
			int n;
			do {
				n = menu(sc);
				manage(sc, conn, pstmt, n);
			} while (!("11".equalsIgnoreCase(String.valueOf(n))));

			sc.close();

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

	}

}
