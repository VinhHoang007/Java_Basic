package example2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Methods {

	public void selectBook1(Connection conn, Scanner sc, PreparedStatement pstmt) {
//		Liet ke cac Books co title la xxx (xxx nhap vao tu ban phim)
		System.out.print("Title: ");
		String title = sc.nextLine();
		String sql = "Select * from books where title =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-6s | %-25s | %-15s | %-7s | %-15s | %-15s | %-4s \n ", "book_id", "title",
					"total_pages", "rating", "isbn", "published_date", "publisher_id");
			while (rs.next()) {
				System.out.printf("%-6d | %-25s | %-15d | %-7.2f | %-15s | %-15s | %-4d \n ", rs.getInt("book_id"),
						rs.getString("title"), rs.getInt("total_pages"), rs.getFloat("rating"), rs.getString("isbn"),
						rs.getDate("published_date"), rs.getInt("publisher_id"));
			}

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

	}

	public void selectBook2(Connection conn, Scanner sc, PreparedStatement pstmt) {
//		liet ke cac books co publisher_name la yyy (yyy nhap vao tu ban phim)
		System.out.println("Publisher name: ");
		String publisher_name = sc.nextLine();
		String sql = "select books.book_id,books.title, publishers.name \r\n" + "from books, publishers\r\n"
				+ "where books.publisher_id = publishers.publisher_id and publishers.name = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher_name);
			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-6s | %-25s | %-15s \n ", "book_id", "title", "publishered_name");
			while (rs.next()) {
				System.out.printf("%-6d | %-25s | %-15s \n ", rs.getInt("book_id"), rs.getString("title"),
						rs.getString("name"));
			}

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

	}

	public void selectBook3(Connection conn, Scanner sc, PreparedStatement pstmt) {
//		Liet ke cac books có title la xxx va dc viet boi publishers name la yyy 
		System.out.print("Title: ");
		String title = sc.nextLine();
		System.out.println("Publisher name: ");
		String publisher_name = sc.nextLine();
		String sql = "select books.book_id, books.title, publishers.name \r\n" + "from books, publishers\r\n"
				+ "where books.publisher_id = publishers.publisher_id and books.title = ? and publishers.name= ?;";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, publisher_name);
			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-6s | %-25s | %-15s \n ", "book_id", "title", "publishered_name");
			while (rs.next()) {
				System.out.printf("%-6d | %-25s | %-15s \n ", rs.getInt("book_id"), rs.getString("title"),
						rs.getString("name"));
			}

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

	}

	public void selectBook4(Connection conn, PreparedStatement pstmt) {
//		Liet ke cac books co total_pages < k (k la so nguyen duong [0-50])
		String sql = "select * from books where total_pages>0 and total_pages <50";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-6s | %-25s | %-15s | %-7s | %-15s | %-15s | %-4s \n ", "book_id", "title",
					"total_pages", "rating", "isbn", "published_date", "publisher_id");
			while (rs.next()) {
				System.out.printf("%-6d | %-25s | %-15d | %-7.2f | %-15s | %-15s | %-4d \n ", rs.getInt("book_id"),
						rs.getString("title"), rs.getInt("total_pages"), rs.getFloat("rating"), rs.getString("isbn"),
						rs.getString("published_date"), rs.getInt("publisher_id"));
			}

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

	}

	public void selectBook5(Connection conn, Scanner sc, PreparedStatement pstmt) {
//		Liet ke cac publishers cung viet book ma title co chu "ABC" (ABC nhap tu ban phim)
		System.out.print("Nhap ky tu can tim: ");
		String title = sc.nextLine();

		String sql = "select books.book_id,books.title, publishers.name \r\n" + "from books, publishers\r\n"
				+ "where books.publisher_id = publishers.publisher_id and books.title like ?;";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-6s | %-25s | %-15s | \n ", "book_id", "title", "name");
			while (rs.next()) {
				System.out.printf("%-6d | %-25s | %-15s | \n ", rs.getInt("book_id"), rs.getString("title"),
						rs.getString("name"));
			}

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

	}

	public void selectBook6(Connection conn, Scanner sc, PreparedStatement pstmt) {
//		 Liet ke cac books dc rating tu x tro len (x la so nguyen nhap vao tu ban phim)
		System.out.print("X: ");
		float x = Float.parseFloat(sc.nextLine());

		String sql = "select * from books where rating >=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, x);
			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-6s | %-25s | %-15s | %-7s | %-15s | %-15s | %-4s \n ", "book_id", "title",
					"total_pages", "rating", "isbn", "published_date", "publisher_id");
			while (rs.next()) {
				System.out.printf("%-6d | %-25s | %-15d | %-7.2f | %-15s | %-15s | %-4d \n ", rs.getInt("book_id"),
						rs.getString("title"), rs.getInt("total_pages"), rs.getFloat("rating"), rs.getString("isbn"),
						rs.getString("published_date"), rs.getInt("publisher_id"));
			}

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

	}

	public void selectBook7(Connection conn, Scanner sc, PreparedStatement pstmt) {
//	 liet ke cac books dc published_date truoc ngay xx/yy/zzzz (xx/yy/zzzz nhap vao tu ban phim
		System.out.print("Date: ");

		String sql = "select * from books where published_date <?";

		try {
			String dateString = sc.nextLine();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dateString);

			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-6s | %-25s | %-15s | %-7s | %-15s | %-15s | %-4s \n ", "book_id", "title",
					"total_pages", "rating", "isbn", "published_date", "publisher_id");
			while (rs.next()) {
				System.out.printf("%-6d | %-25s | %-15d | %-7.2f | %-15s | %-15s | %-4d \n ", rs.getInt("book_id"),
						rs.getString("title"), rs.getInt("total_pages"), rs.getFloat("rating"), rs.getString("isbn"),
						rs.getString("published_date"), rs.getInt("publisher_id"));
			}

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

	}

	public void selectBook8(Connection conn, Scanner sc, PreparedStatement pstmt) {
		System.out.println("Publisher_name: ");
		String name = sc.nextLine();
		System.out.print("Date 1: ");
		String dateMin = sc.nextLine();
		System.out.println("Date 2: ");
		String dateMax = sc.nextLine();
		String sql = "select count(title) as Count " + "from books,publishers "
				+ "where books.publisher_id = publishers.publisher_id and publishers.name = ? and (published_date >? and published_date <?)";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, dateMin);
			pstmt.setString(3, dateMax);

			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-6s", "Count\n");
			while (rs.next()) {
				System.out.printf("%-6d ", rs.getInt("Count"));
			}

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

	}
	public Book input(Scanner sc) {
		Book bk = new Book();
		System.out.println("Title: ");
		bk.setTitle(sc.nextLine());
		System.out.println("Total_pages: ");
		bk.setTotal_pages(Integer.parseInt(sc.nextLine()));
		System.out.println("Rating: ");
		bk.setRating(Float.parseFloat(sc.nextLine()));
		System.out.println("Isbn: ");
		bk.setIsbn(sc.nextLine());
		System.out.println("Publishered_date: ");
		bk.setPublishered_date(sc.nextLine());
		System.out.println("Publisher_id: ");
		bk.setPublisher_id(Integer.parseInt(sc.nextLine()));
		
		return bk;
	}
	public boolean checkInsert(Book bk,PreparedStatement pstmt, Connection conn) {
		
		try {
			String sql = "select * from books "
					+ " where title = ? and total_pages = ? and rating = ? and isbn= ? and Published_date = ? and Publisher_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bk.getTitle());
			pstmt.setInt(2, bk.getTotal_pages());
			pstmt.setFloat(3, bk.getRating());
			pstmt.setString(4, bk.getIsbn());
			pstmt.setString(5, bk.getPublishered_date());
			pstmt.setInt(6, bk.getPublisher_id());		
			ResultSet rs = pstmt.executeQuery();
			boolean check = false;		// k ton tai trong data
			while(rs.next()) {
				check = true;
				System.out.printf("%-5d | %-25s | %-10d | %-10.2f | %-15s | %-15s | %-5d\n"
						,rs.getInt("book_id")
						,rs.getString("title")
						,rs.getInt("total_pages")
						,rs.getFloat("rating")
						,rs.getString("isbn")
						,rs.getString("Published_date")
						,rs.getInt("publisher_id"));
			}
			if(check) {
				return true;
			}
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
		return false;
		
	}

	public void insertBook(Scanner sc,Connection conn, PreparedStatement pstmt) {
		Book bk = new Book();
		bk = input(sc);

		if(!checkInsert(bk, pstmt, conn)) {
			String sql = "INSERT INTO BOOKS (Title,Total_pages,Rating,Isbn,Published_date,Publisher_id) "
					+ " VALUES(?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bk.getTitle());
				pstmt.setInt(2, bk.getTotal_pages());
				pstmt.setFloat(3, bk.getRating());
				pstmt.setString(4, bk.getIsbn());
				pstmt.setString(5, bk.getPublishered_date());
				pstmt.setInt(6, bk.getPublisher_id());

				int i=pstmt.executeUpdate();
				System.out.println(i+" Change");
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
		}
		else {
			System.out.println("Record is existence");
		}
		

	}
	public boolean checkInsertPublisher(Publishers pb,PreparedStatement pstmt, Connection conn) {

		try {
			String sql = "select * from publishers "
					+ " where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pb.getName());

			
			ResultSet rs = pstmt.executeQuery();
			boolean check = false;		
			while(rs.next()) {
				check = true;
				System.out.printf("%-5d | %-25s ",rs.getInt(1),rs.getString(2));

			}
			if(check) {
				return true;
			}
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
		return false;
		
	}

	public void insertPublisher(Scanner sc,Connection conn, PreparedStatement pstmt) {
		Publishers pb = new Publishers();
		System.out.println("Publiser_name: ");
		pb.setName(sc.nextLine());
		if(!checkInsertPublisher(pb, pstmt, conn)) {
			String sql = "INSERT INTO publishers (name) "
					+ " VALUES(?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pb.getName());

				pstmt.executeUpdate();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Record is existence");
		}
		

	}

}
