package book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EbookShop {
	
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName = EBOOK_SHOP;";
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";
	static PreparedStatement pstmt = null;
	static Connection conn = null;

	
	public static boolean checkInsert(Ebook bk) {
		try {

			String sqlSearch = "select * FROM books WHERE title=? and author=?";
			pstmt = conn.prepareStatement(sqlSearch);
			pstmt.setString(1,bk.getTitle());
			pstmt.setString(2,bk.getAuthor());
//			pstmt.setDouble(3, bk.getPrice());
//			pstmt.setInt(4,bk.getQty());
			ResultSet rs = pstmt.executeQuery();
			boolean isCheck = false;
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			System.out.printf("%-4s | %-30s | %-23s | %-15s | %-10s | \n", "ID", "TITLE", "AUTHOR", "PRICE", "QTY");
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");

			while (rs.next()) {
				isCheck = true;
				System.out.printf("%-4d | %-30s | %-23s | %-15.2f | %-10d | \n", rs.getInt("ID"),  rs.getString("title"), rs.getString("author"),rs.getFloat("price"), rs.getInt("Qty"));
				
				bk = new Ebook(rs.getInt("ID"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"),
						rs.getInt("Qty"));
			}
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			if (isCheck) {
				return true;
			} else {
				System.out.println("Record No Existence!!!");
			}

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
		return false;
	}
	public static void insertBook(Connection conn, Scanner sc) {
		Ebook bk = new Ebook();
		System.out.println("=========== NHAP THONG TIN SACH MUON THEM ===========");
		System.out.println();
		System.out.print("TITLE: ");
		bk.setTitle(sc.nextLine());
		System.out.print("AUTHOR: ");
		bk.setAuthor(sc.nextLine());
		System.out.print("PRICE: ");
		bk.setPrice(Float.parseFloat(sc.nextLine()));
		System.out.print("QTY: ");
		bk.setQty(Integer.parseInt(sc.nextLine()));
		
		
		boolean check = checkInsert(bk);
		// check  = true is existence => can not insert
		if(!check) {
			try {
				String sql = "INSERT INTO BOOKS(TITLE,AUTHOR,PRICE,QTY) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, bk.getTitle());
				pstmt.setString(2, bk.getAuthor());
				pstmt.setDouble(3, bk.getPrice());
				pstmt.setInt(4, bk.getQty());
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
		}else {
			System.out.println("Record is existence!!!");
		}
		
	}
	
	public static ArrayList<Ebook> selectAll(Connection conn) {
		ArrayList<Ebook> list = new ArrayList<Ebook>();
		try {
			String sql = "select * from books";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Ebook bk;

			while (rs.next()) {
				bk = new Ebook();
				bk.setId(rs.getInt("id"));
				bk.setTitle(rs.getString("title"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setQty(rs.getInt("qty"));
				list.add(bk);
			}

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
		return list;
	}
	public static ArrayList<Ebook> selectBookTitle(Connection conn, Scanner sc ) {
		ArrayList<Ebook> list = new ArrayList<Ebook>();
		System.out.print("Title:");
		String title = sc.nextLine();
		try {
			String sql = "select * from books where title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			ResultSet rs = pstmt.executeQuery();
			Ebook bk;

			while (rs.next()) {
				bk = new Ebook();
				bk.setId(rs.getInt("id"));
				bk.setTitle(rs.getString("title"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setQty(rs.getInt("qty"));
				list.add(bk);
			}

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
		return list;
	}
	public static ArrayList<Ebook> selectBookAuthor(Connection conn, Scanner sc) {
		ArrayList<Ebook> list = new ArrayList<Ebook>();
		System.out.println("Author: ");
		String author = sc.nextLine();
		try {
			String sql = "select * from books where author = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,author);
			ResultSet rs = pstmt.executeQuery();
			Ebook bk;

			while (rs.next()) {
				bk = new Ebook();
				bk.setId(rs.getInt("id"));
				bk.setTitle(rs.getString("title"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setQty(rs.getInt("qty"));
				list.add(bk);
			}

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
		return list;
	}
	public static ArrayList<Ebook> selectBookPrice(Connection conn, Scanner sc) {
		System.out.println("Nhap gia sach:");
		double price = Double.parseDouble(sc.nextLine());
		ArrayList<Ebook> list = new ArrayList<Ebook>();
		try {
			String sql = "select * from books where Price >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, price);
			ResultSet rs = pstmt.executeQuery();
			Ebook bk;

			while (rs.next()) {
				bk = new Ebook();
				bk.setId(rs.getInt("id"));
				bk.setTitle(rs.getString("title"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setQty(rs.getInt("qty"));
				list.add(bk);
			}

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
		return list;
	}
	
	public static ArrayList<Ebook> selectBookPriceASC(Connection conn) {
		ArrayList<Ebook> list = new ArrayList<Ebook>();
		try {
			String sql = "select * from books ORDER BY PRICE ASC";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Ebook bk;

			while (rs.next()) {
				bk = new Ebook();
				bk.setId(rs.getInt("id"));
				bk.setTitle(rs.getString("title"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setQty(rs.getInt("qty"));
				list.add(bk);
			}

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
		return list;
	}
	
	public static ArrayList<Ebook> selectBookQtyDESC(Connection conn) {
		ArrayList<Ebook> list = new ArrayList<Ebook>();
		try {
			String sql = "select * from books ORDER BY qty DESC";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Ebook bk;

			while (rs.next()) {
				bk = new Ebook();
				bk.setId(rs.getInt("id"));
				bk.setTitle(rs.getString("title"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setQty(rs.getInt("qty"));
				list.add(bk);
			}

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
		return list;
	}



	public static void printListDB(ArrayList<Ebook> list) {
		
		System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
		System.out.printf("%-4s | %-30s | %-23s | %-15s | %-10s | \n", "ID", "TITLE", "AUTHOR", "PRICE", "QTY");
		System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
		for (Ebook bk : list) {
			System.out.printf("%-4d | %-30s | %-23s | %-15.2f | %-10d | \n", bk.getId(), bk.getTitle(), bk.getAuthor(), bk.getPrice(), bk.getQty());
		}
		System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
	}
	public static Ebook checkUpdateID(int id) {
		Ebook bk = new Ebook();
		try {


			String sqlSearch = "select * FROM books WHERE id=?";
			pstmt = conn.prepareStatement(sqlSearch);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			boolean isCheck = false;
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			System.out.printf("%-4s | %-30s | %-23s | %-15s | %-10s | \n", "ID", "TITLE", "AUTHOR", "PRICE", "QTY");
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
	
			


			while (rs.next()) {
				isCheck = true;
				System.out.printf("%-4d | %-30s | %-23s | %-15.2f | %-10d | \n", rs.getInt("ID"),  rs.getString("title"), rs.getString("author"),rs.getFloat("price"), rs.getInt("Qty"));
				
				bk = new Ebook(rs.getInt("ID"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"),
						rs.getInt("Qty"));
			}
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			if (isCheck) {
				return bk;
			} else {
				System.out.println("Record No Existence");
			}

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
		return null;
	}
	
	public static Ebook checkUpdateTitle(String title) {
		Ebook bk = new Ebook();
		try {


			String sqlSearch = "select * FROM books WHERE title=?";
			pstmt = conn.prepareStatement(sqlSearch);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			boolean isCheck = false;
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			System.out.printf("%-4s | %-30s | %-23s | %-15s | %-10s | \n", "ID", "TITLE", "AUTHOR", "PRICE", "QTY");
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
	
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");

			while (rs.next()) {
				isCheck = true;
				System.out.printf("%-4d | %-30s | %-23s | %-15.2f | %-10d | \n", rs.getInt("ID"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"), rs.getInt("Qty"));
				
				bk = new Ebook(rs.getInt("ID"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"),
						rs.getInt("Qty"));
			}
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");

			if (isCheck) {
				return bk;
			} else {
				System.out.println("Record No Existence");
			}

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
		return null;
	}
	public static Ebook checkUpdateTitleAndAuthor(String title, String author) {
		Ebook bk = new Ebook();
		try {


			String sqlSearch = "select * FROM books WHERE title=? and author =?";
			pstmt = conn.prepareStatement(sqlSearch);
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			ResultSet rs = pstmt.executeQuery();
			boolean isCheck = false;
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			System.out.printf("%-4s | %-30s | %-23s | %-15s | %-10s | \n", "ID", "TITLE", "AUTHOR", "PRICE", "QTY");
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
	
			

			while (rs.next()) {
				isCheck = true;
				System.out.printf("%-4d | %-30s | %-23s | %-15.2f | %-10d | \n", rs.getInt("ID"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"),
						rs.getInt("Qty"));
				
				bk = new Ebook(rs.getInt("ID"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"),
						rs.getInt("Qty"));
			}
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			if (isCheck) {
				return bk;
			} else {
				System.out.println("Record No Existence");
			}

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
		return null;
	}
	public static void updateID(Connection conn, Ebook bk) {
		try {

			String sqlUpdate = "Update books SET Title=?, Author = ?, price = ?, "
					+ "qty = ? WHERE id = ?";
			pstmt = conn.prepareStatement(sqlUpdate);

			pstmt.setString(1, bk.getTitle());
			pstmt.setString(2, bk.getAuthor());
			pstmt.setFloat(3, bk.getPrice());
			pstmt.setInt(4, bk.getQty());
			pstmt.setLong(5, bk.getId());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("Update Success!");
			} else {
				System.out.println("Update Failed!");
			}

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
	public static void updateTitle(Connection conn, Ebook bk) {
		try {

			String sqlUpdate = "Update books SET Title=?, Author = ?, price = ?, "
					+ "qty = ? WHERE title = ?";
			pstmt = conn.prepareStatement(sqlUpdate);

			pstmt.setString(1, bk.getTitle());
			pstmt.setString(2, bk.getAuthor());
			pstmt.setFloat(3, bk.getPrice());
			pstmt.setInt(4, bk.getQty());
			pstmt.setString(5, bk.getTitle());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("Update Success!");
			} else {
				System.out.println("Update Failed!");
			}

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
	public static void updateEbookID(Connection Conn, Scanner sc) {

		Ebook bk = new Ebook();
		// Nhap ID
		System.out.print("Input ID:");
		int id = Integer.parseInt(sc.nextLine());

		// Call select record can update -> object Em

		bk = checkUpdateID(id);
		// switch- case

		if (bk != null) {
		
			int key = menuUpdate(sc);
			switch (key) {
			case 1:
				System.out.print("New Title: ");
				String title = sc.nextLine();
				bk.setTitle(title);
				break;
			case 2:
				System.out.print("New Author: ");
				String author = sc.nextLine();
				bk.setAuthor(author);
				break;

			case 3:
				System.out.print("New Price: ");
				float price = Float.parseFloat(sc.nextLine());
				bk.setPrice(price);
				break;
			case 4:
				System.out.print("New Qty: ");
				int Qty = Integer.parseInt(sc.nextLine());
				bk.setQty(Qty);
				break;
			case 5:
				System.out.print("New Title: ");
				String titleAll = sc.nextLine();

				System.out.print("New Author: ");
				String authorAll = sc.nextLine();

				System.out.print("New Price: ");
				float priceAll = Float.parseFloat(sc.nextLine());
				
				System.out.print("New Qty: ");
				int QtyAll = Integer.parseInt(sc.nextLine());
				
			
				bk.setTitle(titleAll);
				bk.setAuthor(authorAll);
				bk.setPrice(priceAll);
				bk.setQty(QtyAll);
				break;
			default:
				System.out.println("Lua chon khong phu hop");
				break;
			}

			// call update

			updateID(Conn, bk);
		} else {
			System.out.println("Update Failed");
		}

	}
	public static void updateEbookTitle(Connection Conn, Scanner sc) {

		Ebook bk = new Ebook();
		// Nhap ID
		System.out.print("Input Title:");
		String titl = sc.nextLine();

		// Call select record can update -> object Em

		bk = checkUpdateTitle(titl);
		// switch- case

		if (bk != null) {
		
			int key = menuUpdate(sc);
			switch (key) {
			case 1:
				System.out.print("New Title: ");
				String title = sc.nextLine();
				bk.setTitle(title);
				break;
			case 2:
				System.out.print("New Author: ");
				String author = sc.nextLine();
				bk.setAuthor(author);
				break;

			case 3:
				System.out.print("New Price: ");
				float price = Float.parseFloat(sc.nextLine());
				bk.setPrice(price);
				break;
			case 4:
				System.out.print("New Qty: ");
				int Qty = Integer.parseInt(sc.nextLine());
				bk.setQty(Qty);
				break;
			case 5:
				System.out.print("New Title: ");
				String titleAll = sc.nextLine();

				System.out.print("New Author: ");
				String authorAll = sc.nextLine();

				System.out.print("New Price: ");
				float priceAll = Float.parseFloat(sc.nextLine());
				
				System.out.print("New Qty: ");
				int QtyAll = Integer.parseInt(sc.nextLine());
				
			
				bk.setTitle(titleAll);
				bk.setAuthor(authorAll);
				bk.setPrice(priceAll);
				bk.setQty(QtyAll);
				break;
			default:
				System.out.println("Lua chon khong phu hop");
				break;
			}

			// call update

			updateTitle(Conn, bk);
		} else {
			System.out.println("Update Failed !!!");
		}

	}
	public static void updatePrice50(Connection conn, Scanner sc) {
		System.out.println("===================== CAP NHAT GIA SACH =====================");
		Ebook bk = new Ebook();
		System.out.println("BooK Title:");
		String title = sc.nextLine();
		System.out.print("Book Author:");
		String author = sc.nextLine();
		bk = checkUpdateTitleAndAuthor(title, author);
		if(bk!= null) {

			try {
				String sql = "update books set price = ? where title = ? and author =?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1,bk.getPrice()*1.5f);
				pstmt.setString(2, bk.getTitle());
				pstmt.setString(3, bk.getAuthor());
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
		}else {
			System.out.println("Update Failed !!!");
		}	
		
	}
	public static boolean checkDelete(int id) {
		try {
			System.out.println("-----------------CHECK BOOK EXISTENCE---------------");

			String sqlSearch = "select * FROM books WHERE id=?";
			pstmt = conn.prepareStatement(sqlSearch);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			boolean isCheck = false;
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			System.out.printf("%-4s | %-30s | %-23s | %-15s | %-10s | \n", "ID", "TITLE", "AUTHOR", "PRICE", "QTY");
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			while (rs.next()) {
				isCheck = true;
				System.out.printf("%-4d | %-30s | %-23s | %-15.2f | %-10d | \n", rs.getInt("ID"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"),
						rs.getInt("Qty"));
				
			}
			System.out.println("+----+--------------------------------+-------------------------+-----------------+------------+");
			if (isCheck) {
				return true;
			}

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
		return false;
	}
	public static void deleteBook(Connection conn, Scanner sc) {
		try {
			System.out.println("-----------------DELETE BOOK---------------");
			System.out.print("ID: ");
			int id = Integer.parseInt(sc.nextLine());
			if (checkDelete(id)) {
				String sqlDelete = "DELETE FROM books WHERE ID=?";
				pstmt = conn.prepareStatement(sqlDelete);
				pstmt.setLong(1, id);
				int rowCount = pstmt.executeUpdate();
				System.out.println(rowCount + " Change");
				System.out.println("Delete Sucess!!!");

			} else {
				System.out.println("Book No Existence!!!");
				System.out.println("Delete Failed!!!");
			}

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
	public static void truncateBook(Connection conn) {
		try {
			System.out.println("-----------------Truncate Book---------------");
			
			
				String sqlTruncate = "TRUNCATE TABLE books";
				pstmt = conn.prepareStatement(sqlTruncate);

				int rowCount = pstmt.executeUpdate();
				System.out.println(rowCount + " Change");
				System.out.println("Truncate Sucess!!!");

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
	public static void selectManyOption(Connection conn) {
		try {
//			String sqlSum = "select sum(qty) as Sum from books";
			String sqlCount = "select count(qty) as count from books";
			pstmt = conn.prepareStatement(sqlCount);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int sum = rs.getInt("count");
				System.out.println(sum);
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}															
	}
	
	
	public static int menuUpdate(Scanner scanner) {
		int n;

		do {
			System.out.println("----------------Update Employee----------------");
			System.out.println();

			System.out.println();
			System.out.println("            1. Update TiTle");
			System.out.println("            2. Update Author");
			System.out.println("            3. Update Price");
			System.out.println("            4. Update Qty");
			System.out.println("            5. Update All");
			System.out.println();
			System.out.println("            Bạn Muốn Chọn Mục Nào?");
			System.out.print("....");
			n = Integer.parseInt(scanner.nextLine());
		} while (!(n >= 1 && n <= 5));
		return n;
	}
	
	public static int menu(Scanner sc) {
		int n;

		do {
			System.out.println("========================= CHUONG TRINH QUAN LY SACH =========================");
			System.out.println();
			System.out.println("                         1. Thêm Sách");
			System.out.println("                         2. Xóa Sách");
			System.out.println("                         3. Cập Nhật Sách Theo ID");
			System.out.println("                         4. Cập Nhật Sách Theo Title");
			System.out.println("                         5. Tìm Kiếm Sách Theo Title ");
			System.out.println("                         6. Tìm Sách Theo Author");
			System.out.println("                         7. Tìm Kiếm Sách Theo PRICE");
			System.out.println("                         8. Cập Nhật Giá Sách");
			System.out.println("                         9. Sắp Xếp Sách Theo Giá Tăng Dần");
			System.out.println("                        10. Sắp Xếp Sách Theo Qty Giảm Dần");
			System.out.println("                        11. Hiển Thị Toàn Bộ Thông Tin Sách");
			System.out.println("                        12. Xóa Toàn Bộ Bảng (truncate)");
			System.out.println("                        13. Select Many Option");
			System.out.println("                        14. Quit");
			System.out.println();
			System.out.print("                         Nhập Lựa Chọn Của Bạn... ");
			n = Integer.parseInt(sc.nextLine());


		} while (!(n >= 1 && n <= 14));
		return n;
	}
	public static void manageProgram(int n,Scanner sc) {

		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database ...");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			ArrayList<Ebook> list= new ArrayList<Ebook>();
			switch (n) {
			case 1:
				insertBook(conn, sc);
				break;
			case 2:
				deleteBook(conn, sc);
				break;		
			case 3:
				updateEbookID(conn,sc);
				break;
			case 4:
				updateEbookTitle(conn,sc);
				break;
			case 5:
				list = selectBookTitle(conn, sc);
				printListDB(list);
				break;
			case 6:
				list = selectBookAuthor(conn, sc);
				printListDB(list);
				break;
			case 7:
				list= selectBookPrice(conn, sc);
				printListDB(list);
				break;
			case 8:
				updatePrice50(conn, sc);
				break;
			case 9:
				list=selectBookPriceASC(conn);
				printListDB(list);
				break;
			case 10:
				list = selectBookQtyDESC(conn);
				printListDB(list);
				break;
			case 11:
				list = selectAll(conn);
				printListDB(list);
				break;
			case 12:
				truncateBook(conn);
				break;	
			case 13:
				selectManyOption(conn);
				break;	
			case 14:
				System.out.println("Chuong Trinh Ket Thuc");
				break;	
			default:
				System.out.println("Dau Vao Khong Hop Le!!!");
				break;
			}
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
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			n = menu(sc);
			manageProgram(n,sc);

		} while (!"14".equalsIgnoreCase(String.valueOf(n)));
	
		sc.close();
	}

}
