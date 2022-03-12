package JDPC_DEMO;
import java.sql.*;
import java.util.Scanner;

public class JDBC_TEST {
	
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName =TEST_JDBC;";
	
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";
	
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	
//	public static void insertElement(Connection conn) {
//		Scanner sc  = new Scanner(System.in);
//
//		System.out.println("MaKH: ");
//		String MaKH = sc.next();
//		System.out.println("TenKH: ");
//		String TenKH = sc.nextLine();
//		System.out.println("DiaChi:");
//		String DiaChi = sc.nextLine();
//		System.out.println("SoDienThoai:");
//		String SoDienThoai = sc.next();
//		String sqlInsert = "INSERT INTO KHACH_HANG VALUES(?,?,?,?)";
////		String sqlInsert = "INSERT INTO KHACH_HANG"+ "VALUES(?,?,?,?)";
//		
//		try {
//			pstmt = conn.prepareStatement(sqlInsert);
//			pstmt.set 
//		} catch (Exception e) {
//		}
		
//	}
	public static void selectAll(Connection conn) {
		String sql = "SELECT * FROM KHACH_HANG";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// Retrieve by column name
//				String MaKH = rs.getString("MaKH");
//				String TenKH = rs.getString("TenKH");
//				String DiaChi = rs.getString("DiaChi");
//				String SoDienThoai = rs.getString("SoDT");

				// Display values
				System.out.printf("%5s | %50s | %12s | \n", 
						rs.getString(1),rs.getString(3), rs.getString(4));
			
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void selectElement(Connection conn) {
		Scanner scanner = new Scanner(System.in);
//		System.out.print("Nhap Ma Khach Hang");
//		String tenkh = scanner.nextLine();
		
		
		try {
			String sql = "select KHACH_HANG.MaKH, KHACH_HANG.TenKH,"
					+ " DAT_PHONG.MaPhong, DICH_VU_DI_KEM.TenDV,"
					+ " CHI_TIET_SU_DUNG_DV.SoLuong, DICH_VU_DI_KEM.DonGia "
					+ " from KHACH_HANG,CHI_TIET_SU_DUNG_DV, DICH_VU_DI_KEM, DAT_PHONG "
					+ " WHERE KHACH_HANG.MaKH = DAT_PHONG.MaKH "
					+ " and DAT_PHONG.MaDatPhong = CHI_TIET_SU_DUNG_DV.MaDatPhong "
					+ " and DICH_VU_DI_KEM.MaDV = CHI_TIET_SU_DUNG_DV.MaDV";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,tenkh);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String MaKH = rs.getString("MaKH");
//				String TenKH = rs.getString("TenKH");
//				String MaPhong = rs.getString("MaPhong");
				String TenDV = rs.getString("TenDV");
				int SoLuong = rs.getInt("SoLuong");
				double DonGia = rs.getDouble("DonGia");
//				String DiaChi = rs.getString("DiaChi");
//				String SoDienThoai = rs.getString("SoDT");
//				System.out.printf("%5s | %20s | %50s | %12s | %10d|%10f\n", MaKH,TenKH,MaPhong,TenDV,SoLuong,DonGia);
				System.out.printf("%5s | %12s | %10d|%10f\n", MaKH,TenDV,SoLuong,DonGia);
			
				}
			
		} catch (SQLException se) {
			
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Khach Hang Khong Ton Tai");
		}
		
		
		
	}
	public static void main(String[] args) {
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connect to database...");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connect sucess!!!");
//			selectAll(conn);
			selectElement(conn);
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
