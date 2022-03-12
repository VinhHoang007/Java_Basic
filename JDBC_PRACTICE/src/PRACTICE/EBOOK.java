package PRACTICE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EBOOK {

	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName =EBOOK_SHOP;";
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static Scanner sc = new Scanner(System.in);

	public static void insertBook(Connection conn) {

		System.out.println("=========== NHAP THONG TIN SACH MUON THEM ===========");
		System.out.println();
		System.out.print("TITLE: ");
		String title = sc.nextLine();
		System.out.print("AUTHOR: ");
		String author = sc.nextLine();
		System.out.print("PRICE: ");
		double price = Double.parseDouble(sc.nextLine());
		System.out.print("QTY: ");
		int qty = Integer.parseInt(sc.nextLine());
		try {
			String sql = "INSERT INTO BOOKS(TITLE,AUTHOR,PRICE,QTY) VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setDouble(3, price);
			pstmt.setInt(4, qty);
			pstmt.executeUpdate();
			System.out.println("INSERT SUCCESS!!!");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("INSERT FAILED!!!");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
	}
	
	public static void updateBookID(Connection conn) {
		System.out.println("NHAP THONG TIN MUON UPDATE THEO ID");
		
		int id;
		do {
			System.out.print("ID: ");
			id = sc.nextInt();
		} while (id<=1000);
		System.out.println();
		System.out.print("TITLE: ");
		String title = sc.nextLine();
		System.out.print("AUTHOR: ");
		String author = sc.nextLine();
		System.out.print("PRICE: ");
		double price = Double.parseDouble(sc.nextLine());
		System.out.print("QTY: ");
		int qty = Integer.parseInt(sc.nextLine());
		try {
			String sql = "UPDATE BOOKS SET TITLE = ?, AUTHOR =?, PRICE =?, QTY =? WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setDouble(3, price);
			pstmt.setInt(4, qty);
			pstmt.setInt(5,id );
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		
	}
	
	public static void updateBookTitle(Connection conn) {
		System.out.println("NHAP THONG TIN MUON UPDATE THEO TITLE");
		
		System.out.println("Nhập Title Muốn Update:");
		String title = sc.nextLine();
		System.out.print("Nhập Thông Tin Update:");
		System.out.println();
		System.out.print("TITLE: ");
		String titlenew = sc.nextLine();
		System.out.print("AUTHOR: ");
		String author = sc.nextLine();
		System.out.print("PRICE: ");
		double price = Double.parseDouble(sc.nextLine());
		System.out.print("QTY: ");
		int qty = Integer.parseInt(sc.nextLine());
		try {
			String sql = "UPDATE BOOKS SET TITLE = ?, AUTHOR =?, PRICE =?, QTY =? WHERE TITLE=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, titlenew);
			pstmt.setString(2, author);
			pstmt.setDouble(3, price);
			pstmt.setInt(4, qty);
			pstmt.setString(5,titlenew);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		
	}
	
	public static void updatePrice50(Connection conn) {
		System.out.println("=====================CAP NHAT GIA SACH=====================");
		
		System.out.println("BooK Title:");
		String title = sc.nextLine();
		System.out.print("Book Author:");
		String author = sc.nextLine();
	

		try {
			String sql = "update books \r\n"
					+ "set price = (select price from books\r\n"
					+ "where title = ? and author = ?)*1.5";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.executeUpdate();
			System.out.println("Update Price Sucess!!!!");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		
	}
	
	public static void selectBookTitle(Connection conn) {
		System.out.println("===================TIM KIEM THONG TIN THEO TITLE===================");
		System.out.print("TITLE: ");
		String title = sc.nextLine();
		System.out.println();
		System.out.println("=====================================DATABASE=====================================");
		
		try {
			String sql = "SELECT * FROM BOOKS  WHERE TITLE=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			System.out.printf("%4s | %30s | %15s |  %10s | %8s | \n", "ID", "Title", "Author","price","QTY");
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			while(rs.next()) {
				System.out.printf("%4d | %30s | %15s |  %10.2f | %8d | \n", rs.getInt("ID"), rs.getString("Title"), rs.getString("Author"),rs.getDouble("price") ,
						rs.getInt("QTY"));
			}
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
		}
		
	}
	public static void selectBookAuthor(Connection conn) {
		System.out.println("===================TIM KIEM THONG TIN THEO AUTHOR===================");
		System.out.print("AUTHOR: ");
		String author = sc.nextLine();
		System.out.println();
		System.out.println("=====================================DATABASE=====================================");
		System.out.printf("%4s | %30s | %15s |  %10s | %8s | \n", "ID", "Title", "Author","price","QTY");
		System.out.println("+-----+-------------------------------+-------------------------+------------------+----------+");
		try {
			String sql = "SELECT * FROM BOOKS  WHERE AUTHOR=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, author);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			System.out.printf("%4s | %30s | %15s |  %10s | %8s | \n", "ID", "Title", "Author","price","QTY");
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			while(rs.next()) {
				System.out.printf("%4d | %30s | %15s |  %10.2f | %8d | \n", rs.getInt("ID"), rs.getString("Title"), rs.getString("Author"),rs.getDouble("price") ,
						rs.getInt("QTY"));
			}
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
		}	
	}
	public static void selectBookPriceAsc(Connection conn) {

		System.out.println("=====================================DATABASE=====================================");
		
		try {
			String sql = "select * from books\r\n"
					+ "ORDER BY price ASC; ";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			System.out.printf("%4s | %30s | %15s |  %10s | %8s | \n", "ID", "Title", "Author","PRICE","QTY");
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			while(rs.next()) {
				System.out.printf("%4d | %30s | %15s |  %10.2f | %8d | \n", rs.getInt("ID"), rs.getString("Title"), rs.getString("Author"),rs.getDouble("price") ,
						rs.getInt("QTY"));
			}
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
		}	
	}
	
	public static void selectBookQtyeDsc(Connection conn) {

		System.out.println("=====================================DATABASE=====================================");
		
		try {
			String sql = "select * from books\r\n"
					+ "ORDER BY qty DESC;";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			System.out.printf("%4s | %30s | %15s |  %10s | %8s | \n", "ID", "Title", "Author","PRICE","QTY");
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			while(rs.next()) {
				System.out.printf("%4d | %30s | %15s |  %10.2f | %8d | \n", rs.getInt("ID"), rs.getString("Title"), rs.getString("Author"),rs.getDouble("price") ,
						rs.getInt("QTY"));
			}
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
		}	
	}
	public static void selectBookPrice(Connection conn) {
		System.out.println("===================TIM KIEM THONG TIN THEO PRICE===================");
		System.out.print("Gia Tien X: ");
		double x = sc.nextDouble();
		System.out.println();
		System.out.println("=====================================DATABASE=====================================");
		
		try {
			String sql = "SELECT * FROM BOOKS  WHERE price>=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, x);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			System.out.printf("%4s | %30s | %15s |  %10s | %8s | \n", "ID", "Title", "Author","PRICE","QTY");
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			while(rs.next()) {
				System.out.printf("%4d | %30s | %15s |  %10.2f | %8d | \n", rs.getInt("ID"), rs.getString("Title"), rs.getString("Author"),rs.getDouble("price") ,
						rs.getInt("QTY"));
			}
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");

		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
		}
		
	}
	public static void selectBookAll(Connection conn) {

		System.out.println("=====================================DATABASE=====================================");
		
		try {
			String sql = "SELECT * FROM BOOKS";
			pstmt = conn.prepareStatement(sql);
		
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			System.out.printf("%4s | %-30s | %15s |  %10s | %8s | \n", "ID", "Title", "Author","PRICE","QTY");
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
			while(rs.next()) {
				System.out.printf("%-4d | %-30s | %-15s |  %-10.2f | %-8d | \n", rs.getInt("ID"), rs.getString("Title"), rs.getString("Author"),rs.getDouble("price") ,
						rs.getInt("QTY"));
			}
			System.out.println("+----+--------------------------------+-----------------+-------------+----------+");
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
		}	
	}
	
//	public static void main(String[] args) {
//
//		try {
//			Class.forName(JDBC_DRIVER);
//			System.out.println("Connecting to database ...");
//			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//			
////			insertBook(conn);
////			selectBookAuthor(conn);
////			selectBookTitle(conn);
////			selectBookPrice(conn);
////			updatePrice(conn);
//			selectBookPriceAsc(conn);
//			selectBookQtyeDsc(conn);
//			
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.getMessage();
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//
//	}

}
