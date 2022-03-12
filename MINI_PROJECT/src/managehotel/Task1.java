package managehotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

//	Set Gia Tri Cho Doi Tuong Khach Hang
	public Customer inputCustomer(Scanner sc, Connection conn, PreparedStatement pstmt) {
		Customer cus = new Customer();

		cus.setCustomer_id(Checking.autoIncreaseID(conn, pstmt));
		cus.setFullName(Checking.inputFullName(sc));
		cus.setPhone(Checking.inputPhone(sc));
		cus.setAddress(Checking.inputAddress(sc));
		return cus;
	}

//	Chuc Nang Them Thong Tin Khach Hang  
	public void insertCustomer(Scanner sc, Connection conn, PreparedStatement pstmt) {
		Customer cus = new Customer();
		boolean isLoop = true;
		do {
			String identity = Checking.inputIdentity(sc);

			if (!"full".equalsIgnoreCase(Checking.autoIncreaseID(conn, pstmt))) {
				if (!Checking.checkExistenceCustomer(identity, pstmt, conn)) {
					isLoop = false;
					String sql = "INSERT INTO KHACH_HANG VALUES(?,?,?,?,?)";

					cus = inputCustomer(sc, conn, pstmt);
					cus.setIdentity(identity);
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, cus.getCustomer_id());
						pstmt.setString(2, cus.getIdentity());
						pstmt.setString(3, cus.getFullName());
						pstmt.setString(4, cus.getPhone());
						pstmt.setString(5, cus.getAddress());
						pstmt.executeUpdate();
						System.out.println(" Them Thong Tin Khach Hang Thanh Cong!!!");
					} catch (SQLException se) {
						se.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if (pstmt != null)
								pstmt.close();
						} catch (SQLException se2) {
							se2.printStackTrace();
						}
					}
				} else {
					isLoop = true;
					System.out.println(" Thong Tin Cua Khach Hang Da Ton Tai!!!");
				}
			} else {
				System.out.println(" Bo Nho Day, Vui Long Khong Insert");
				isLoop = false;
			}

		} while (isLoop);

	}

//	Chuc Nang Cap Nhat Thong Tin Khach Hang     
	public void updateCustomer(Scanner sc, Connection conn, PreparedStatement pstmt) {
		Customer cus = new Customer();
		String identity = Checking.inputIdentity(sc);

//		Kiem Tra CMND Da Co Trong Bang Khang Hang Hay Chua? Neu Co Thi Tien Hanh Update
		if (Checking.checkExistenceCustomer(identity, pstmt, conn)) {
			String chose =null;
			boolean check;
//			Hien Thi Menu Update
			do {
				check = true;
				System.out.println("+-------------------------------+");
				System.out.println("| Ban Muon Update Theo Muc Nao? |");
				System.out.println("+-------------------------------+");
				System.out.printf("| %-30s|\n| %-30s| \n| %-30s| \n| %-30s| \n| %-30s|\n", "1. Identity",
						"2. Full Name", "3. Phone", "4. Address", "5. All Fields");
				System.out.println("+-------------------------------+");
				System.out.print(" From Update Menu, Your Choice: ");
				chose = sc.nextLine().trim();
				if (!("1".equals(chose) || "2".equals(chose) || "3".equals(chose) || "4".equals(chose)
						|| "5".equals(chose))) {
					check = false;
					System.out.println(" Gia Tri Nhap Vao Phai La So Nguyen Tu 1 Den 5!!!");
				}
			} while (!(Checking.isNumber(chose) && check));

			switch (chose) {
//			Update CMND
			case "1":

				String newID = Checking.inputIdentity(sc);
//					Kiem Tra CMND Muon Update Da Ton Tai Trong Bang Chua
				if (!Checking.checkExistenceCustomer(newID, pstmt, conn)) {
					String sql1 = "UPDATE KHACH_HANG SET CMND =? WHERE CMND =?";

					try {
						pstmt = conn.prepareStatement(sql1);
						pstmt.setString(1, newID);
						pstmt.setString(2, identity);
						pstmt.executeUpdate();
						System.out.println(" Update Identity Successfully!!!");
					} catch (SQLException se) {
						se.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if (pstmt != null)
								pstmt.close();
						} catch (SQLException se2) {
							se2.printStackTrace();
						}
					}
				} else {
					System.out.println(" ERROR: Identity Moi Da Ton Tai Trong He Thong!!!");
					System.out.println(" INFOR: Ban Khong Duoc Phep Update Trung Gia Tri Trong Database!!!");

				}

				break;
//			Update Ho Va Ten
			case "2":
				String sql2 = "UPDATE KHACH_HANG SET HoVaTen =? WHERE CMND =?";
				String fullName = Checking.inputFullName(sc);
				try {
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, fullName);
					pstmt.setString(2, identity);
					pstmt.executeUpdate();
					System.out.println(" Update Full Name Successfully!!!");
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException se2) {
						se2.printStackTrace();
					}
				}
				break;
//			Update So Dien Thoai
			case "3":

				String phone = Checking.inputPhone(sc);
				String sql3 = "UPDATE KHACH_HANG SET SDT =? WHERE CMND =?";
				try {
					pstmt = conn.prepareStatement(sql3);
					pstmt.setString(1, phone);
					pstmt.setString(2, identity);
					pstmt.executeUpdate();
					System.out.println(" Update Phone Successfully!!!");
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException se2) {
						se2.printStackTrace();
					}
				}

				break;

//			Update Dia Chi	
			case "4":
				String sql4 = "UPDATE KHACH_HANG SET DiaChi =? WHERE CMND =?";
				System.out.print(" Input Address:");
				String address = Checking.inputAddress(sc);
				try {
					pstmt = conn.prepareStatement(sql4);
					pstmt.setString(1, address);
					pstmt.setString(2, identity);
					pstmt.executeUpdate();
					System.out.println(" Update Address Successfully!!!");
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException se2) {
						se2.printStackTrace();
					}
				}
				break;

//			Update Cac Truong Tru MaKH
			case "5":

				String newIDAll = Checking.inputIdentity(sc);
//				Kiem Tra CMND Muon Update Da Ton Tai Trong Bang Chua
				if (!Checking.checkExistenceCustomer(newIDAll, pstmt, conn)) {
					String sql5 = "UPDATE KHACH_HANG SET CMND =?, HoVaTen =?, SDT =?, DiaChi =? WHERE CMND =?";
					cus = inputCustomer(sc, conn, pstmt);
					cus.setIdentity(newIDAll);
					try {
						pstmt = conn.prepareStatement(sql5);
						pstmt.setString(1, cus.getIdentity());
						pstmt.setString(2, cus.getFullName());
						pstmt.setString(3, cus.getPhone());
						pstmt.setString(4, cus.getAddress());
						pstmt.setString(5, identity);
						pstmt.executeUpdate();
						System.out.println(" Update Thong Tin Khach Hang Thanh Cong!!!");
					} catch (SQLException se) {
						se.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if (pstmt != null)
								pstmt.close();
						} catch (SQLException se2) {
							se2.printStackTrace();
						}
					}
				} else {
					System.out.println(" ERROR: Identity Moi Da Ton Tai Trong He Thong!!!");
					System.out.println(" INFOR: Ban Khong Duoc Phep Update Trung Gia Tri Trong Database!!!");
				}

				break;
			}
		} else {
			System.out.println(" Khong Tim Thay Thong Tin Khach Hang!!!");
		}
	}

//	Xoa Thong Tin Khach Hang 
	public void deleteCustomer(Scanner sc, Connection conn, PreparedStatement pstmt) {
		String identity = Checking.inputIdentity(sc);
		try {
//			Kiem Tra Su Ton Ton Tai Cua Khach Hang, Neu Ton Tai Thi Tien Hanh Xoa
			if (Checking.checkExistenceCustomer(identity, pstmt, conn)) {
				String sqlSelectKH = "SELECT MaKH from KHACH_HANG WHERE CMND=?";
				pstmt = conn.prepareStatement(sqlSelectKH);
				pstmt.setString(1, identity);
				String maKH = null;
				ResultSet rs1 = pstmt.executeQuery();
				while (rs1.next()) {
					maKH = rs1.getString(1);
				}
				String chose = null;

//				Kiem Tra Khach Hang Co Da Booking Chua

				if (Checking.checkExistenceBooking(maKH, pstmt, conn)) {

//				Kiem Tra Khach Hang Chua Thanh Toan

					if (Checking.checkNoPayment(identity, pstmt, conn)) {
						System.out.println(" INFOR: Khach Hang Chua Thanh Toan Tien Phong!!!");
					}
					do {
						System.out.print(" Ban Co Muon Xoa Khach Hang Nay Y/N?");
						chose = sc.nextLine().trim();
					} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));

					if ("Y".equalsIgnoreCase(chose)) {

//						Liet Ke Ma Dat Phong Tuong Ung Voi Khach Hang

						String sqlSelectDP = "SELECT MaDatPhong from DAT_PHONG WHERE MaKH=?";
						pstmt = conn.prepareStatement(sqlSelectDP);
						pstmt.setString(1, maKH);
						ResultSet rs2 = pstmt.executeQuery();
						ArrayList<String> list = new ArrayList<>();
						while (rs2.next()) {
							list.add(rs2.getString(1));
						}

//						Xoa Ma Dat Phong Trong Bang CHI_TIET_DAT_PHONG

						for (int i = 0; i < list.size(); i++) {
							String sqlDelete1 = "DELETE FROM CHI_TIET_DAT_PHONG WHERE MaDatPhong=?";
							pstmt = conn.prepareStatement(sqlDelete1);
							pstmt.setString(1, list.get(i));
							pstmt.executeUpdate();
							
//							Xoa Ma KH Trong Bang CHI_TIET_DAT_PHONG
							String sqlDelete2 = "DELETE FROM CHI_TIET_DAT_PHONG WHERE MaKH=?";
							pstmt = conn.prepareStatement(sqlDelete2);
							pstmt.setString(1, maKH);
							pstmt.executeUpdate();
//							Xoa Ma Dat Phong Trong Bang CHI_TIET_SU_DUNG_DV

							String sqlDelete3 = "DELETE FROM CHI_TIET_SU_DUNG_DV WHERE MaDatPhong=?";
							pstmt = conn.prepareStatement(sqlDelete3);
							pstmt.setString(1, list.get(i));
							pstmt.executeUpdate();

//							Xoa Record Trong Bang DAT_PHONG

							String sqlDelete4 = "DELETE FROM DAT_PHONG WHERE MaKH=? and MaDatPhong =?";
							pstmt = conn.prepareStatement(sqlDelete4);
							pstmt.setString(1, maKH);
							pstmt.setString(2, list.get(i));
							pstmt.executeUpdate();
						}

//						Xoa Khach Hang Trong Bang KHACH_HANG

						String sqlDelete4 = "DELETE FROM KHACH_HANG WHERE MaKH=?";
						pstmt = conn.prepareStatement(sqlDelete4);
						pstmt.setString(1, maKH);
						if (pstmt.executeUpdate() != 0) {
							System.out.println(" Delete Successfull!!!");
						}

					} else {
						System.out.println(" INFOR: Khong Co Khach Hang Nao Bi Xoa!!!");
					}

				} else {

					do {
						System.out.print(" Ban Co Muon Xoa Khach Hang Nay Y/N?");
						chose = sc.nextLine().trim();
					} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));

					if ("Y".equalsIgnoreCase(chose)) {

//						Xoa Khach Hang Trong Bang CHI_TIET_DAT_PHONG

						String sqlDelete5 = "DELETE FROM CHI_TIET_DAT_PHONG WHERE MaKH=?";
						pstmt = conn.prepareStatement(sqlDelete5);
						pstmt.setString(1, maKH);
						pstmt.executeUpdate();

//						Xoa Khach Hang Trong Bang KHACH_HANG

						String sqlDelete6 = "DELETE FROM KHACH_HANG WHERE MaKH=?";
						pstmt = conn.prepareStatement(sqlDelete6);
						pstmt.setString(1, maKH);
						pstmt.executeUpdate();
						System.out.println(" Delete Successfull!!!");
					} else {
						System.out.println(" Khong Co Khach Hang Nao Bi Xoa!!!");
					}
				}

			} else {
				System.out.println(" Khach Hang Khong Ton Tai!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}

	}

}
