package managehotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Checking {
//	Nhap CMND Va Validate
	public static String inputIdentity(Scanner sc) {
		String identity;
		boolean check = true;
		do {
			System.out.print(" Input Identity: ");
			identity = sc.nextLine().trim().replaceAll("\\s+", "");
			if (!identity.isBlank()) {
				if (identity.length() == 9 && Checking.isNumber(identity) && identity.charAt(0) != '-'
						&& (!Checking.isSpecialCharacter(identity))) {
					check = true;
				} else if (identity.charAt(0) == '-') {
					System.out.println(" ERROR: Identity Khong Duoc Am !!!");
					check = false;
				} else if (Checking.isSpecialCharacter(identity)) {
					System.out.println(" ERROR: Identity Khong Chua Ky Tu Dac Biet !!!");
					check = false;
				} else {
					System.out.println(" ERROR: Identity Bao Gom 9 Chu So !!!");
					check = false;
				}
			} else {
				check = false;
				System.out.println(" ERROR: Khong Duoc Bo Trong, Vui Long Nhap Lai!!!");
			}

		} while (!check);
		return identity;

	}

//	Nhap Ho Va Ten Va Validate
	public static String inputFullName(Scanner sc) {
		String fullName;
		boolean check = true;
		do {
			System.out.print(" Input Full Name: ");
			fullName = sc.nextLine().trim().replaceAll("\\s+", " ");
			if (!fullName.isBlank()) {

				if ((!Checking.isNumber(fullName)) && !Checking.isSpecialCharacter(fullName)) {
					check = true;
				} else if (Checking.isNumber(fullName)) {
					System.out.println(" ERROR: Full Name Khong Duoc Chua Toan So  !!!");
					check = false;
				} else {
					System.out.println(" ERROR: Full Name Khong Duoc Chua Ky Tu Dac Biet  !!!");
					check = false;
				}
			} else {
				check = false;
				System.out.println(" ERROR: Khong Duoc Bo Trong, Vui Long Nhap Lai!!!");
			}

		} while (!check);
		return fullName;
	}

//	Ma Tu Tang
	public static String autoIncreaseID(Connection conn, PreparedStatement pstmt) {

		String id = null;
		ResultSet rs = null;
		try {

//	Lay gia tri MaKH duoi cung bang cach sap xep tu cao den thap, lay phan tu top 1
			String sql = "select TOP(1) MaKH from KHACH_HANG ORDER BY MaKH DESC";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boolean check = false;
			String maKH = null;
			while (rs.next()) {
				check = true;
				maKH = rs.getString("MaKH");

			}
			int customer_id = Integer.parseInt(maKH.substring(2));
			if (customer_id < 9999) {
				if (check) {
//			Ep phan so trong MaKH thanh int va tang gia tri len 1, sau do ep kieu thanh string

					id = "" + (customer_id + 1);
					int leng = id.length();

//			Them ky tu 0 phia truoc so nhung dam bao do dai phan so trong makh khong qua 4

					for (int i = 0; i < 4 - leng; i++) {
						id = "0" + id;
					}
				} else {
//			Khong ton tai gia tri trong MAKH thi phan tu phan tien la KH0001
					id = "0001";
				}
			} else {
				return "full";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return "KH" + id;

	}

//	Nhap Address Va Validate
	public static String inputAddress(Scanner sc) {
		String address;
		boolean check = true;
		do {
			System.out.print(" Input Address: ");
			address = sc.nextLine().trim().replaceAll("\\s+", " ");

			if ((!Checking.isNumber(address)) && !Checking.isSpecialCharacter(address)) {
				check = true;
			} else if (Checking.isNumber(address)) {
				System.out.println(" ERROR: Address Khong Duoc Chua Toan So  !!!");
				check = false;
			} else {
				System.out.println(" ERROR: Address Name Khong Duoc Chua Ky Tu Dac Biet  !!!");
				check = false;
			}

		} while (!check);
		return address;
	}

//	Nhap So Dien Thoai Va Validate
	public static String inputPhone(Scanner sc) {
		String phone;
		boolean check = true;
		do {
			System.out.print(" Input Phone:");
			phone = sc.nextLine().trim().replaceAll("\\s+", "");
			if (!phone.isBlank()) {
				if (phone.length() == 10 && phone.charAt(0) == '0' && Checking.isNumber(phone)
						&& (!Checking.isSpecialCharacter(phone))) {
					check = true;
				} else if (phone.charAt(0) != '0') {
					check = false;
					System.out.println(" ERROR: So Dien Thoai Bat Dau Bang So 0!!!");
				} else if (Checking.isSpecialCharacter(phone)) {
					check = false;
					System.out.println(" ERROR: So Dien Thoai Chua Ky Tu Dac Biet!!!");
				} else {
					check = false;
					System.out.println(" ERROR: So Dien Thoai Gom 10 Chu So!!!");
				}
			} else {
				check = false;
				System.out.println(" ERROR: Khong Duoc Bo Trong!!!");
			}
		} while (!check);
		return phone;
	}

//	Kiem Tra Kieu Du Lieu So Nguyen
	public static boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

//	Kiem Tra Ky Tu Dac Biet
	public static boolean isSpecialCharacter(String ch) {
		for (int i = 0; i < ch.length(); i++) {
			if (Pattern.matches("[@#$%^&*!?<>+=()_`~?;.\\\"]", ch.charAt(i) + "")) {
				return true;
			}
		}
		return false;
	}

//	Kiem Tra Khach Hang Su Ton Tai Cua Khach Hang
	public static boolean checkExistenceCustomer(String identity, PreparedStatement pstmt, Connection conn) {

		ResultSet rs = null;
		try {
			String sql = "select * from KHACH_HANG WHERE CMND = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identity);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return false;

	}

//	Kiem Tra Dinh Dang Ngay

	@SuppressWarnings("deprecation")
	public static boolean isValidDate(String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateFormat.setLenient(false);
			Date checkYear = dateFormat.parse(date);
			if (checkYear.getYear() >= 9999) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Boolean isValidEndDate(Scanner sc, String endDayString, Date dateStart) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEnd;

		if (isValidDate(endDayString)) {
			try {
				dateFormat.setLenient(false);
				dateEnd = dateFormat.parse(endDayString);
				if (dateEnd.before(dateStart)) {
					System.out.println(" ERROR: End Day After Start Day!!!");
					return false;
				} else {
					return true;
				}
			} catch (Exception e) {
				return false;
			}

		} else {
			System.out.println(" ERROR: Dinh Dang End Day Khong Dung!!!");
			return false;
		}

	}

//	Kiem Tra Tinh Trang Booking Cua Khach Hang 
	public static boolean checkExistenceBooking(String maKH, PreparedStatement pstmt, Connection conn) {
		ResultSet rs = null;
		try {
			String sql = "select * from DAT_PHONG WHERE MaKH = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maKH);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return false;

	}

//	Kiem Tra Tinh Trang Booking Cua Khach Hang 	Va Su Ton Tai Cua Khach Hang
	public static boolean checkBooking(String identity, PreparedStatement pstmt, Connection conn) {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			if (Checking.checkExistenceCustomer(identity, pstmt, conn)) {
				String maKH = null;
				String sqlSelectKH = "SELECT MaKH from KHACH_HANG WHERE CMND=?";
				pstmt = conn.prepareStatement(sqlSelectKH);
				pstmt.setString(1, identity);
				rs1 = pstmt.executeQuery();

				while (rs1.next()) {
					maKH = rs1.getString(1);
				}

				String sqlSelectDP = "SELECT MaDatPhong from DAT_PHONG WHERE MaKH=?";
				pstmt = conn.prepareStatement(sqlSelectDP);
				pstmt.setString(1, maKH);
				rs2 = pstmt.executeQuery();

				while (rs2.next()) {
					return true;
				}
			} else {
				System.out.println(" INFOR: Khach Hang Khong Ton Tai!!!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (rs2 != null) {
					rs2.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}

		return false;
	}

//	Kiem Tra Tinh Trang Thanh Toan Cua Khach
	public static boolean checkNoPayment(String identity, PreparedStatement pstmt, Connection conn) {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			if (Checking.checkExistenceCustomer(identity, pstmt, conn)) {
				String maKH = null;
				String sqlSelectKH = "SELECT MaKH from KHACH_HANG WHERE CMND=?";
				pstmt = conn.prepareStatement(sqlSelectKH);
				pstmt.setString(1, identity);
				rs1 = pstmt.executeQuery();

				while (rs1.next()) {
					maKH = rs1.getString(1);
				}

				String sqlSelectDP = "select * from DAT_PHONG where MaKH = ? AND TinhTrangThanhToan = 0";
				pstmt = conn.prepareStatement(sqlSelectDP);
				pstmt.setString(1, maKH);
				rs2 = pstmt.executeQuery();

				while (rs2.next()) {
					return true;
				}
			} else {
				System.out.println(" INFOR: Khach Hang Khong Ton Tai!!!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (rs2 != null) {
					rs2.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}

		return false;
	}

//	Nhap Thang Nam Va Kiem Tra Dinh Dang Thang Nam
	public static ArrayList<Integer> checkYearMonth(Scanner sc) {
		int month = 0;
		int year = 0;
		boolean checkExcep;
		boolean checkMonth;
		boolean checkYear;
		ArrayList<Integer> list = new ArrayList<Integer>();
		do {
			checkExcep = false;
			checkMonth = true;
			try {
				System.out.print(" Input Month: ");
				month = Integer.parseInt(sc.nextLine());
				checkExcep = true;
				if (!(month >= 1 && month <= 12)) {
					checkMonth = false;
					System.out.println(" ERROR: Dinh Dang Thang Khong Hop Le");
				} else {
					list.add(month);
				}
			} catch (Exception e) {
				System.out.println(" INFOR: Thang Hop Le La So Nguyen Tu 1 Den 12!!! ");
				checkExcep = false;
			}

		} while (!(checkExcep && checkMonth));

		do {
			checkExcep = false;
			checkYear = true;
			try {
				System.out.print(" Input Year: ");
				year = Integer.parseInt(sc.nextLine());
				checkExcep = true;
				if (!(String.valueOf(year).length() == 4 && String.valueOf(year).charAt(0) != '0' && String.valueOf(year).charAt(0) != '-')) {
					checkYear = false;
					System.out.println(" ERROR: Dinh Dang Nam Khong Hop Le !!!");
				} else {
					list.add(year);
				}
			} catch (Exception e) {
				System.out.println(" INFOR: Nam Hop Le La So Nguyen Co 4 Chu So Va Khong Bat Dau So 0!!! ");
				checkExcep = false;
			}

		} while (!(checkExcep && checkYear));

		return list;
	}

}
