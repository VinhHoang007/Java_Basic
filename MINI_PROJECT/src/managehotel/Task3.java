package managehotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Task3 {

//	Hien Thi Thong Tin Khach Hang Da O Tu Ngay A Den Ngay B Bao Gom Phong   

	public void getInforCusRoomID(Scanner sc, Connection conn, PreparedStatement pstmt){

		System.out.println(" Dinh Dang Ngay Cua Chuong Trinh yyyy-MM-dd ");
		String startDayString;
		String endDayString;

		Date dateStart = null;
		boolean isLoop = false;
		do {
			System.out.print(" Input Start Day: ");
			startDayString = sc.nextLine().trim();
			
//			Kiem Tra Dinh Dang Ngay Nhap
			
			if (Checking.isValidDate(startDayString)) {
				isLoop = false;
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//					Chuyen Tu String -> Date
					dateStart = dateFormat.parse(startDayString); 
				} catch (Exception e) {
					isLoop = true;
				}
			} else {
				isLoop = true;
				System.out.println(" ERROR: Dinh Dang Start Day Khong Dung!!!");
			}
		} while (isLoop);

		do {
			System.out.print(" Input End Day: ");
			endDayString = sc.nextLine().trim();
		} while (!Checking.isValidEndDate(sc, endDayString, dateStart));

//		startDay < endDay
//		Tim nguoi o trong khoang (startDay,endDay): !(endDay<NgayDatPhong || startDay>NgayTraPhong)
//		Trong sql endDay >=DP.NgayDatPhong  AND startDay <= DP.NgayTraPhong
		ResultSet rs = null;
		try {
//			Show Thong Tin Khach Hang Da O Trong Khoang Start Day -> End Day
			String sql = "SELECT KH.*, CTDP.MaPhong \n"
					+ "FROM KHACH_HANG as KH, DAT_PHONG as DP, CHI_TIET_DAT_PHONG as CTDP \n"
					+ "WHERE CTDP.MaDatPhong = DP.MaDatPhong AND KH.MaKH = CTDP.MaKH \n"
					+ "AND (? >=DP.NgayDatPhong  AND ? <= DP.NgayTraPhong )"
					+ "ORDER BY KH.MaKH;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, endDayString);
			pstmt.setString(2, startDayString);
			rs = pstmt.executeQuery();
			boolean check = false;
			System.out.println(
					"+--------+------------+-------------------------+------------+----------------------------------------+--------+");
			System.out.printf("| %-6s | %-10s | %-23s | %-10s | %-38s | %-6s| \n", "CUS_ID", "IDENTITY", "FULL NAME",
					"PHONE", "ADDRESS", "ROOM_ID");
			System.out.println(
					"+--------+------------+-------------------------+------------+----------------------------------------+--------+");
			while (rs.next()) {
				check = true;

				System.out.printf("| %-6s | %-10s | %-23s | %-10s | %-38s | %-6s | \n", rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			System.out.println(
					"+--------+------------+-------------------------+------------+----------------------------------------+--------+");
			System.out.println();
			if (!check) {
				System.out.println(" INFOR: Khong Co Khach O Trong Khoang Thoi Gian Nay !!!");
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

	}

//	Tinh Tien Thue Phong Khach San
	public static ArrayList<RoomMoney> getRoomMoney(Scanner sc, Connection conn, PreparedStatement pstmt) {
		ArrayList<RoomMoney> list = new ArrayList<RoomMoney>();
		ResultSet rs = null;
//		Tinh Tien Phong
		try {
			String sql = "select TRUY_VAN_CON.MaDatPhong,TRUY_VAN_CON.CMND, SUM(Tien_Phong) as TongTienPhong\r\n"
					+ "from (\r\n"
					+ "select  CHI_TIET_DAT_PHONG.MaPhong,DAT_PHONG.MaDatPhong,KHACH_HANG.CMND,phong.GiaPhong*DATEDIFF(day,DAT_PHONG.NgayDatPhong,DAT_PHONG.NgayTraPhong) Tien_Phong\r\n"
					+ "from DAT_PHONG, CHI_TIET_DAT_PHONG, PHONG, KHACH_HANG\r\n"
					+ "where DAT_PHONG.TinhTrangThanhToan = 0 and DAT_PHONG.MaDatPhong = CHI_TIET_DAT_PHONG.MaDatPhong\r\n"
					+ "and CHI_TIET_DAT_PHONG.MaPhong = PHONG.MaPhong and DAT_PHONG.MaKH = KHACH_HANG.MaKH\r\n"
					+ "GROUP BY DAT_PHONG.MaDatPhong,KHACH_HANG.CMND,  CHI_TIET_DAT_PHONG.MaPhong,phong.GiaPhong*DATEDIFF(day,DAT_PHONG.NgayDatPhong,DAT_PHONG.NgayTraPhong)\r\n"
					+ ")  TRUY_VAN_CON\r\n"
					+ "GROUP BY TRUY_VAN_CON.MaDatPhong,TRUY_VAN_CON.CMND\r\n"
					+ "ORDER BY TRUY_VAN_CON.MaDatPhong";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			RoomMoney rm;
			boolean check = false;
			while (rs.next()) {
				check = true;
				rm = new RoomMoney();
				rm.setBooking_ID(rs.getString(1));
				rm.setIdentity(rs.getString(2));
				rm.setRoomMoney(rs.getInt(3));
				list.add(rm);
			}
			if (!check) {
				System.out.println(" INFOR: Khong Ton Tai Du Lieu !!!");
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

	public static ArrayList<ServiceMoney> getServiceMoney(Scanner sc, Connection conn, PreparedStatement pstmt) {
		ArrayList<ServiceMoney> list = new ArrayList<ServiceMoney>();
		ResultSet rs = null;
		try {
//			Hien Thi Tien Dich Vu
			String sql = "select  DAT_PHONG.MaDatPhong, SUM(DICH_VU.DonGia * CHI_TIET_SU_DUNG_DV.SoLuong) AS TONG_TIEN_DV\r\n"
					+ "from DICH_VU, CHI_TIET_SU_DUNG_DV,DAT_PHONG\r\n"
					+ "where  CHI_TIET_SU_DUNG_DV.MaDV = DICH_VU.MaDV \r\n"
					+ "and CHI_TIET_SU_DUNG_DV.MaDatPhong = DAT_PHONG.MaDatPhong and DICH_VU.TrangThaiDV = 1 and DAT_PHONG.TinhTrangThanhToan = 0\r\n"
					+ "GROUP BY DAT_PHONG.MaDatPhong";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ServiceMoney sm;
			boolean check = false;
			while (rs.next()) {
				check = true;
				sm = new ServiceMoney();
//				Set Gia Tri Cho Doi Tuong Tien Dich Vu
				sm.setBooking_ID(rs.getString(1));
				sm.setServiceMoney(rs.getInt(2));
				list.add(sm);
			}
			if (!check) {
				System.out.println(" INFOR: Khong Co Phong Order Dich Vu !!!");
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

	public void calMoney(Scanner sc, Connection conn, PreparedStatement pstmt) {

		ArrayList<RoomMoney> listRoomMoney = getRoomMoney(sc, conn, pstmt);
		ArrayList<ServiceMoney> listServiceMoney = getServiceMoney(sc, conn, pstmt);
		
//		Tinh Tong Tien Dich Vu Va Tien Phong
		for (RoomMoney rm : listRoomMoney) {
			for (ServiceMoney sm : listServiceMoney) {
				if (rm.getBooking_ID().equals(sm.getBooking_ID())) {
					rm.setRoomMoney(rm.getRoomMoney() + sm.getServiceMoney());
				}
			}
		}

		System.out.println();

		System.out.println("+----------+-----------+----------+");
		System.out.printf("|%-10s| %-9s | %-8s |\n", "BOOKING_ID", "IDENTITY", "MONEY");
		System.out.println("+----------+-----------+----------+");
		for (RoomMoney value : listRoomMoney) {
			System.out.printf("|%-10s| %-9s | %-8s |\n", value.getBooking_ID(), value.getIdentity(),
					value.getRoomMoney());
		}
		System.out.println("+----------+-----------+----------+");
		System.out.println();

		String identity = Checking.inputIdentity(sc);

		if (Checking.checkBooking(identity, pstmt, conn)) {
			
//			Thuc Hien Tinh Tien Cho Khach
			int sumMoney = 0;
			for (RoomMoney sm : listRoomMoney) {
				if (identity.equals(sm.getIdentity())) {
					sumMoney = sumMoney + sm.getRoomMoney();
				}
			}

			Task2 t2 = new Task2();
			ArrayList<Customer> list = t2.getCustomerID(identity, sc, conn, pstmt);
//			In Thong Tin Va Tong Tien Cua Khach
			System.out.println(
					"+--------+------------+-------------------------+------------+-------------------------------------+--------+");
			System.out.printf("| %-6s | %-10s | %-23s | %-10s | %-35s | %-6s | \n", "CUS_ID", "IDENTITY", "FULL NAME",
					"PHONE", "ADDRESS", "MONEY");
			System.out.println(
					"+--------+------------+-------------------------+------------+-------------------------------------+--------+");
			for (Customer cus : list) {
				System.out.printf("| %-6s | %-10s | %-23s | %-10s | %-35s |%-6s | \n", cus.getCustomer_id(),
						cus.getIdentity(), cus.getFullName(), cus.getPhone(), cus.getAddress(), sumMoney);
			}
			System.out.println(
					"+--------+------------+-------------------------+------------+-------------------------------------+--------+");
			System.out.println();

		} else {
			if (Checking.checkExistenceCustomer(identity, pstmt, conn)) {
				System.out.println(" INFOR: Khach Hang Khong Dat Phong !!!");
			}
		}

	}
}
