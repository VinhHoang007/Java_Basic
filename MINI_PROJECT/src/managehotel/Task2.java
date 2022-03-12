package managehotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
	// 1. Liet Ke Danh Sach Khach Hang
	public ArrayList<Customer> getInforAllCustomer(Connection conn, PreparedStatement pstmt) {
		ArrayList<Customer> list = new ArrayList<Customer>();
		ResultSet rs = null;
		try {
			String sql = "select * from KHACH_HANG";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Customer cus;

			while (rs.next()) {
				cus = new Customer();
				cus.setCustomer_id(rs.getString(1));
				cus.setIdentity(rs.getString(2));
				cus.setFullName(rs.getString(3));
				cus.setPhone(rs.getString(4));
				cus.setAddress(rs.getString(5));
				list.add(cus);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return list;
	}

//	5. Hien Thi Thong Tin Khach Hang Theo CMND 
	public ArrayList<Customer> getCustomerID(String identity, Scanner sc, Connection conn, PreparedStatement pstmt) {
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
			String sql = "select * from KHACH_HANG WHERE CMND = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identity);
			ResultSet rs = pstmt.executeQuery();
			Customer cus;
			boolean check = false;
			while (rs.next()) {
				check = true;
				cus = new Customer();
				cus.setCustomer_id(rs.getString(1));
				cus.setIdentity(rs.getString(2));
				cus.setFullName(rs.getString(3));
				cus.setPhone(rs.getString(4));
				cus.setAddress(rs.getString(5));
				list.add(cus);
			}
			if (!check) {
				System.out.println(" INFOR: Khach Hang Khong Ton Tai !!!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
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
		return list;
	}

//	Hien Thi Khach Hang Da Tung Dat Khach San Trong Thang Y Nam Z 
	public ArrayList<Customer> getCusMonthYear(Scanner sc, Connection conn, PreparedStatement pstmt) {
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		ArrayList<Integer> listMonthYear = Checking.checkYearMonth(sc);
		ResultSet rs = null;
		try {
			
			String sql = "select DISTINCT KHACH_HANG.*  \n" + "from DAT_PHONG, KHACH_HANG \n"
					+ "WHERE DAT_PHONG.MaKH = KHACH_HANG.MaKH and month(DAT_PHONG.NgayDatPhong) = ? and year(DAT_PHONG.NgayDatPhong) = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, listMonthYear.get(0)); // Month
			pstmt.setInt(2, listMonthYear.get(1)); // Year
			rs = pstmt.executeQuery();
			Customer cus;
			boolean check = false;
			while (rs.next()) {
				check = true;
				cus = new Customer();
				cus.setCustomer_id(rs.getString(1));
				cus.setIdentity(rs.getString(2));
				cus.setFullName(rs.getString(3));
				cus.setPhone(rs.getString(4));
				cus.setAddress(rs.getString(5));
				list.add(cus);
			}
			if (!check) {
				System.out.println(" INFOR: Khong Co Khach Dat Phong trong thang "+listMonthYear.get(0)+ " nam " +listMonthYear.get(1)+" !!!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
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
		return list;
	}

//	In Danh Sach Khach Hang Theo ArrayList
	public void printListDB(ArrayList<Customer> list) {
		if (!list.isEmpty()) {
			System.out.println(
					"                                ============== DATABASE ==============                         ");
			System.out.println(
					"+--------+------------+--------------------+------------+-----------------------------------+");
			System.out.printf("| %-6s | %-10s | %-18s | %-10s | %-33s | \n", "CUS_ID", "IDENTITY", "FULL NAME", "PHONE",
					"ADDRESS");
			System.out.println(
					"+--------+------------+--------------------+------------+-----------------------------------+");
			for (Customer cus : list) {
				System.out.printf("| %-6s | %-10s | %-18s | %-10s | %-33s | \n", cus.getCustomer_id(),
						cus.getIdentity(), cus.getFullName(), cus.getPhone(), cus.getAddress());
			}
			System.out.println(
					"+--------+------------+--------------------+------------+-----------------------------------+");
			System.out.println();
		}

	}

}
