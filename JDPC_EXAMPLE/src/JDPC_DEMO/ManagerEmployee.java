package JDPC_DEMO;

//STEP 1. Import required packages
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ManagerEmployee {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName =ManagerEmployee;";

	// User and password
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";
	public static void selectAllEmployee(Connection conn) {

		Statement stmt = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT * FROM employee";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set

			while (rs.next()) {
				// Retrieve by column name
				long id = rs.getLong("ID");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String address = rs.getString("Address");
				double salary = rs.getDouble("Salary");
				int sumtimework = rs.getInt("SumTimeWork");

				// Display values

				System.out.print("ID: " + id);
				System.out.print(", Name: " + name);
				System.out.print(", Age: " + age);
				System.out.print(", Address: " + address);
				System.out.print(", Salary: " + salary);
				System.out.println(", SumTimeWork: " + sumtimework);
			}
			System.out.println("Goodbye!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void insertEmployee(Connection conn) {
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		PreparedStatement pstmt = null;
		do {
			System.out.println("-------------Nhap thong tin nhan vien-------------");
			

			System.out.println("Name: ");
			String name = scanner.nextLine();

			
			System.out.println("Age: ");
			int age = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Address: ");
			String address = scanner.nextLine();

			
			System.out.println("Salary: ");
			double salary = scanner.nextDouble();
			System.out.println("SumTimeWork: ");
			int sumtimework = scanner.nextInt();

			
			String sqlInsert = "INSERT INTO Employee(Name,Age,Address,Salary,SumTimeWork) "
					+ "VALUES(?,?,?,?,?)";
			try {
				
				pstmt = conn.prepareStatement(sqlInsert);				
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				pstmt.setString(3, address);
				pstmt.setDouble(4, salary);
				pstmt.setInt(5, sumtimework);
				pstmt.execute();
				
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print("Ban co muon nhap tiep khong ? (Y/N): ");
			choice = scanner.next();
			scanner.nextLine();
		} while ("Y".equalsIgnoreCase(choice));

	}

	public static void updateEmployee(Connection conn) {
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("-------------Nhap thong tin muon thay doi-------------");
			System.out.println("ID: ");
			long id = scanner.nextLong();
			scanner.nextLine();
			System.out.println("Name: ");
			String name = scanner.nextLine();

			System.out.println("Age: ");
			int age = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Address: ");
			String address = scanner.nextLine();
			System.out.println("Salary: ");
			double salary = scanner.nextDouble();
			System.out.println("SumTimeWork: ");
			int sumtimework = scanner.nextInt();

			String sqlUpdate = "Update Employee SET Name=?, Age = ?, Address = ?, "
					+ "Salary = ?, SumTimeWork =? WHERE id = ?";
			pstmt = conn.prepareStatement(sqlUpdate);

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, address);
			pstmt.setDouble(4, salary);
			pstmt.setInt(5, sumtimework);
			pstmt.setLong(6, id);
			pstmt.executeUpdate();
			System.out.println("Update Success!");
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	public static void deleteEmployee(Connection conn) {
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("-------------NHAP NHAN VIEN MUON XOA-------------");
			System.out.println("ID: ");
			long id = scanner.nextLong();
			String sqlDelete = "DELETE FROM Employee WHERE ID=?";
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			System.out.println("Delete Success!");
		} catch (Exception e) {
			System.out.println("Delete Failed!");
		}
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException se2) {
		} // nothing we can do

	}
	public static void findEmployee(Connection conn) {
		Statement stmt = null;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("-------------NHAP NHAN VIEN MUON TIM KIEM-------------");
			System.out.println("Name: ");
			String Name = scanner.nextLine();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT * FROM employee WHERE Name = '"+Name+"';";
			ResultSet rs = stmt.executeQuery(sql);


			while (rs.next()) {
				// Retrieve by column name
				long id = rs.getLong("ID");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String address = rs.getString("Address");
				double salary = rs.getDouble("Salary");
				int sumtimework = rs.getInt("SumTimeWork");

				// Display values

				System.out.print("ID: " + id);
				System.out.print(", Name: " + name);
				System.out.print(", Age: " + age);
				System.out.print(", Address: " + address);
				System.out.print(", Salary: " + salary);
				System.out.println(", SumTimeWork: " + sumtimework);
			}

			System.out.println("Find Sucess!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Open a connection
			System.out.println("Connecting to database ...");

			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			System.out.println("Creating statement...");
//			insertEmployee(conn);
//			selectAllEmployee(conn);
//			updateEmployee(conn);
//			deleteEmployee(conn);
			findEmployee(conn);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		

	}
}
