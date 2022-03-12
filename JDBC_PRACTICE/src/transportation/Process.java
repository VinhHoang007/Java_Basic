package transportation;
import java.sql.*;
import java.util.Scanner;
public class Process {
	
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName = transportation;";
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";
	
	public static int menu(Scanner sc) {
		int n;
		do {
			System.out.println("=============== Chuong trinh quan ly giao thong cong cong =============== ");
			System.out.println(" 1. Select option 1");
			System.out.println(" 2. Select option 2");
			System.out.println(" 3. Select option 3");
			System.out.println(" 4. Select option 4");
			System.out.println(" 5. Select option 5");
			System.out.println(" 6. Select option 6");
			System.out.println(" 7. Select option 7");
			System.out.println(" 8. Select option 8");
			System.out.println(" 9. Select option 9");
			System.out.println("10. Select option 10");
			System.out.println("11. Insert Nha Cung Cap ");
			System.out.println("12. Insert Loai Dich Vu ");
			System.out.println("13. Insert Muc Phi ");
			System.out.println("14. Insert Dong Xe");
			System.out.println("15. Insert Dang Ky Cung Cap");
			System.out.println("16. Quit ");
			System.out.println("Nhap gia tri n:");
			n = Integer.parseInt(sc.nextLine());
			
		} while (!(n>=1 && n<=16));
		return n;
	}
	
	public static void manage(int key,Connection conn, PreparedStatement pstmt,Scanner sc) {
		Method mt = new Method();
		switch (key) {
			case 1:
//				Liệt kê những dòng xe có số chỗ ngồi trên 5 chỗ
				mt.select1(sc, conn, pstmt);
				break;
			case 2:
				mt.select2(sc, conn, pstmt);
				break;
			case 3:
				mt.select3(sc, conn, pstmt);
				break;	
			case 4:
				break;	
			case 5:
				break;	
			case 6:
				break;	
			case 7:
				break;	
			case 8:
				break;	
			case 9:
				break;	
			case 10:
				break;
			case 11:
				mt.insertNCC(sc, conn, pstmt);
				break;
			case 12:
				mt.insertLDV(sc, conn, pstmt);
				break;	
			case 13:
				mt.insertMP(sc, conn, pstmt);
				break;
			case 14:
				mt.insertDX(sc, conn, pstmt);
				break;	
			case 15:
				mt.insertDK(sc, conn, pstmt);
				break;	
		}
	}
	
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connecting to database ...");
			Scanner sc = new Scanner(System.in);
			int n;
			do {
				n = menu(sc);
				manage(n, conn, pstmt,sc);
			} while (!("16".equalsIgnoreCase(String.valueOf(n))));
			sc.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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

