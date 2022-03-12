package managehotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName = QUAN_LY_KHACH_SAN;";
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";

	public static void menuList() {
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("+------------------ CHUONG TRINH QUAN LY KHACH SAN ------------------+");
		System.out.println("|                                *****                               |");
		System.out.println("| 1. Liet Ke Danh Sach Khach Hang                                    |");
		System.out.println("| 2. Them Thong Tin Khach Hang                                       |");
		System.out.println("| 3. Cap Nhat Thong Tin Khach Hang                                   |");
		System.out.println("| 4. Xoa Thong Tin Khach Hang                                        |");
		System.out.println("| 5. Hien Thi Thong Tin Khach Hang Theo CMND                         |");
		System.out.println("| 6. Hien Thi Khach Hang Da Tung Dat Khach San Trong Thang Y Nam Z   |");
		System.out.println("| 7. Hien Thi Thong Tin Khach Hang Da O Tu Ngay A Den Ngay B         |");
		System.out.println("| 8. Tinh Tien Thue Phong Khach San                                  |");
		System.out.println("| 9. Thoat Chuong Trinh                                              |");
		System.out.println("+--------------------------------------------------------------------+");
	}

	public static int choseValueMenu(Scanner sc) {
		int input = 0;

		boolean isLoop;

		do {
			String n;
			isLoop = false;
			System.out.print(" From Menu List, Your Choice: ");
			n = sc.nextLine().trim();
			System.out.println();
			if (Checking.isNumber(n)) {
				input = Integer.parseInt(n);
				if (!(input >= 0 && input <= 9)) {
					isLoop = true;
					System.out.println(" Lua Chon Tu 0 Den 9 !!!");
				}
			} else {
				System.out.println(" Ky Tu Nhap Vao Khong Phai La So Nguyen !!!");
				isLoop = true;
			}

		} while (isLoop);
		return input;
	}

	public static void manage(Scanner sc, Connection conn, PreparedStatement pstmt, int key) {
		Task1 t1 = new Task1();
		Task2 t2 = new Task2();
		Task3 t3 = new Task3();
		String chose = null;
		switch (key) {
		case 0:
			menuList();
			break;
		case 1:
			ArrayList<Customer> list1 = new ArrayList<>();
			list1 = t2.getInforAllCustomer(conn, pstmt);
			t2.printListDB(list1);
			break;
		case 2:
			do {
				System.out.println(" ====== INSERT FUNCTION ======");
				t1.insertCustomer(sc, conn, pstmt);
				do {
					System.out.print(" Do You Want To Continue INSERT Function Y/N?");
					chose = sc.nextLine().trim();
				} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));
			} while ("Y".equalsIgnoreCase(chose));
			System.out.println();
			break;
		case 3:

			do {
				System.out.println(" ======== UPDATE FUNCTION ========");
				t1.updateCustomer(sc, conn, pstmt);
				do {
					System.out.print(" Do You Want Continue UPDATE Function Y/N?");
					chose = sc.nextLine().trim();
				} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));
			} while ("Y".equalsIgnoreCase(chose));
			System.out.println();
			break;
		case 4:
			do {
				System.out.println(" ======== DELETE FUNCTION ========");
				t1.deleteCustomer(sc, conn, pstmt);
				do {
					System.out.print(" Do You Want To Continue DELETE Function Y/N?");
					chose = sc.nextLine().trim();
				} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));
			} while ("Y".equalsIgnoreCase(chose));
			System.out.println();
			break;

		case 5:
			do {

				System.out.println(" ====== SHOWING CUSTOMER ACCORDING TO ID FUNCTION ======");
				ArrayList<Customer> list2 = new ArrayList<>();
				String identity = Checking.inputIdentity(sc);
				list2 = t2.getCustomerID(identity, sc, conn, pstmt);
				t2.printListDB(list2);
				do {
					System.out.print(" Do You Want To Continue Case 5 Y/N?");
					chose = sc.nextLine().trim();
				} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));
			} while ("Y".equalsIgnoreCase(chose));
			System.out.println();
			break;
		case 6:
			do {
				System.out.println(" ====== SHOWING CUSTOMER BOOKING HOTEL FUNCTION ======");
				ArrayList<Customer> list3 = new ArrayList<>();
				list3 = t2.getCusMonthYear(sc, conn, pstmt);
				t2.printListDB(list3);
				do {
					System.out.print(" Do You Want to Continue Case 6 Y/N?");
					chose = sc.nextLine().trim();
				} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));
			} while ("Y".equalsIgnoreCase(chose));
			System.out.println();
			break;
		case 7:
			do {
				System.out.println(" ====== SHOWING INFORMATION & ROOM CUSTOMER FUNCTION ======");
				t3.getInforCusRoomID(sc, conn, pstmt);
				do {
					System.out.print(" Do You Want to Continue Case 7 Y/N?");
					chose = sc.nextLine().trim();
				} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));
			} while ("Y".equalsIgnoreCase(chose));
			System.out.println();
			break;
		case 8:
			do {
				System.out.println(" ====== CALCULATOR MONEY FUNCTION ======");
				t3.calMoney(sc, conn, pstmt);
				do {
					System.out.print(" Do You Want Continue Calculate MONEY Function Y/N?");
					chose = sc.nextLine().trim();
				} while (!("Y".equalsIgnoreCase(chose) || "N".equalsIgnoreCase(chose)));
			} while ("Y".equalsIgnoreCase(chose));

			break;
		case 9:
			System.out.println(" PROGRAM IS FINISH!!!");
			break;
		}
		if (!(key == 0 || key == 9)) {
			System.out.println(" Nhan Phim 0 Neu Muon Hien Thi Menu!!!");
		}
	}

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = null;
		try {

			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			menuList();
			sc = new Scanner(System.in);
			int n;
			do {
				n = choseValueMenu(sc);
				manage(sc, conn, pstmt, n);
			} while (!(n == 9));

			sc.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (sc != null) {
					sc.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
