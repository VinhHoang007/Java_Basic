package ASSIGNMENT_DAY14;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName =ManagerEmployee;";

	// User and password
	static final String USERNAME = "sa";
	static final String PASSWORD = "1234567890";
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	

	public static Employee inputEm(Scanner scanner) {

		System.out.print("Name: ");
		String name = scanner.nextLine();

		System.out.print("Age: ");
		int age = Integer.parseInt(scanner.nextLine());

		System.out.print("Address: ");
		String address = scanner.nextLine();

		System.out.print("Salary: ");
		double salary = Double.parseDouble(scanner.nextLine());
		System.out.print("SumTimeWork: ");
		int sumtimework = Integer.parseInt(scanner.nextLine());

		Employee em = new Employee();
		em.setName(name);
		em.setAge(age);
		em.setAddress(address);
		em.setSalary(salary);
		em.setSumTimeWork(sumtimework);
		return em;
	}

	public static void updateEmployee(Connection Conn, Scanner sc) {

		Employee emp = new Employee();
		// Nhap ID
		System.out.print("Input ID:");
		long id = Integer.parseInt(sc.nextLine());

		// Call select record can update -> object Em

		emp = checkUpdate(id);
		// switch- case

		if (emp != null) {
		
			int key = menuUpdate(sc);
			switch (key) {
			case 1:
				System.out.print("New Name: ");
				String name = sc.nextLine();
				emp.setName(name);
				break;
			case 2:
				System.out.print("New Age: ");
				int age = Integer.parseInt(sc.nextLine());
				emp.setAge(age);
				break;
			case 3:
				System.out.print("New Address: ");
				String address = sc.nextLine();
				emp.setAddress(address);
				break;
			case 4:
				System.out.print("New Salary: ");
				double salary = Double.parseDouble(sc.nextLine());
				emp.setSalary(salary);
				break;
			case 5:
				System.out.print("New SumTimeWork: ");
				int sumtimework = Integer.parseInt(sc.nextLine());
				emp.setSumTimeWork(sumtimework);
				break;
			case 6:
				System.out.print("New Name: ");
				String nameAll = sc.nextLine();

				System.out.print("New Age: ");
				int ageAll = Integer.parseInt(sc.nextLine());

				System.out.print("New Address: ");
				String addressAll = sc.nextLine();

				System.out.print("New Salary: ");
				double salaryAll = Double.parseDouble(sc.nextLine());
				System.out.print("New SumTimeWork: ");
				int sumtimeworkAll = Integer.parseInt(sc.nextLine());
				emp.setName(nameAll);
				emp.setAge(ageAll);
				emp.setAddress(addressAll);
				emp.setSalary(salaryAll);
				emp.setSumTimeWork(sumtimeworkAll);
				break;
			default:
				System.out.println("Lua chon khong phu hop");
				break;
			}

			// call update

			update(Conn, emp);
		} else {
			System.out.println("Update Failed");
		}

	}

	public static Employee checkUpdate(long id) {
		Employee emp = new Employee();
		try {
			System.out.println("-----------------CHECK EMPLOYEE EXISTENCE---------------");

			String sqlSearch = "select * FROM Employee WHERE id=?";
			pstmt = conn.prepareStatement(sqlSearch);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			boolean isCheck = false;
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
			System.out.printf("%-4S | %-23s | %-3s | %-27s | %-15s | %-7s | \n", "ID", "NAME", "AGE", "ADDRESS",
					"SALARY", "SUMTIMEWORK");
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
			while (rs.next()) {
				isCheck = true;
				System.out.printf("%-4d | %-23s | %-3d | %-27s | %-15.2f | %-11d | \n", rs.getLong("ID"),
						rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getDouble("Salary"),
						rs.getInt("SumTimeWork"));
				emp = new Employee(rs.getLong("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"),
						rs.getDouble("Salary"), rs.getInt("SumTimeWork"));
			}
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
			if (isCheck) {
				return emp;
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
	public static void update(Connection conn, Employee emp) {
		try {

			String sqlUpdate = "Update Employee SET Name=?, Age = ?, Address = ?, "
					+ "Salary = ?, SumTimeWork =? WHERE id = ?";
			pstmt = conn.prepareStatement(sqlUpdate);

			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getAge());
			pstmt.setString(3, emp.getAddress());
			pstmt.setDouble(4, emp.getSalary());
			pstmt.setInt(5, emp.getSumTimeWork());
			pstmt.setLong(6, emp.getId());
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
	public static boolean checkInsert(Employee emp) {
		try {

			String sqlSearch = "select * FROM Employee WHERE name=? and age=? and address =? and salary =? and sumtimework =?";
			pstmt = conn.prepareStatement(sqlSearch);
			pstmt.setString(1,emp.getName());
			pstmt.setInt(2,emp.getAge());
			pstmt.setString(3, emp.getAddress());
			pstmt.setDouble(4,emp.getSalary());
			pstmt.setInt(5,emp.getSumTimeWork());
			ResultSet rs = pstmt.executeQuery();
			boolean isCheck = false;
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
			System.out.printf("%-4S | %-23s | %-3s | %-27s | %-15s | %-7s | \n", "ID", "NAME", "AGE", "ADDRESS", "SALARY",
					"SUMTIMEWORK");
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");

			while (rs.next()) {
				isCheck = true;
				long id = rs.getLong("ID");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String address = rs.getString("Address");
				double salary = rs.getDouble("Salary");
				int sumtimework = rs.getInt("SumTimeWork");
				System.out.printf("%-4d | %-23s | %-3d | %-27s | %-15.2f | %-11d | \n", id, name, age, address, salary,
						sumtimework);
				
			}
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
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

	public static void insertEmployee(Connection conn,Scanner sc) {

		String sqlInsert = "INSERT INTO Employee(Name,Age,Address,Salary,SumTimeWork) " + "VALUES(?,?,?,?,?)";
		try {
			Employee em = inputEm(sc);
			if(!checkInsert(em)) {
				pstmt = conn.prepareStatement(sqlInsert);
				pstmt.setString(1, em.getName());
				pstmt.setInt(2, em.getAge());
				pstmt.setString(3, em.getAddress());
				pstmt.setDouble(4, em.getSalary());
				pstmt.setInt(5, em.getSumTimeWork());
				
				int i = pstmt.executeUpdate();
				if (i > 0) {
					System.out.println("Insert Success!!!");
				} else {
					System.out.println("Insert Failed!!!");
				}
			}else {
				System.out.println("Record is existence!!!");
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

	public static void selectAllEmployee(Connection conn) {
		System.out.println("-----+-------------------------+---"
				+ "--+-----------------------------+-----------------+-------------+");
		System.out.printf("%-4S | %-23s | %-3s | %-27s | %-15s | %-7s | \n", "ID", "NAME", "AGE", "ADDRESS", "SALARY",
				"SUMTIMEWORK");
		System.out.println("-----+-------------------------+---"
				+ "--+-----------------------------+-----------------+-------------+");
		try {
			String sql = "SELECT * FROM employee";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

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
				System.out.printf("%-4d | %-23s | %-3d | %-27s | %-15.2f | %-11d | \n", id, name, age, address, salary,
						sumtimework);
			}
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
			System.out.println("Thank you!");
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
	public static boolean checkDelete(long id) {
		try {
			System.out.println("-----------------CHECK EMPLOYEE EXISTENCE---------------");

			String sqlSearch = "select * FROM Employee WHERE id=?";
			pstmt = conn.prepareStatement(sqlSearch);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			boolean isCheck = false;
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
			System.out.printf("%-4S | %-23s | %-3s | %-27s | %-15s | %-7s | \n", "ID", "NAME", "AGE", "ADDRESS",
					"SALARY", "SUMTIMEWORK");
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
			while (rs.next()) {
				isCheck = true;
				System.out.printf("%-4d | %-23s | %-3d | %-27s | %-15.2f | %-11d | \n", rs.getLong("ID"),
						rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getDouble("Salary"),
						rs.getInt("SumTimeWork"));

			}
			System.out.println("-----+-------------------------+---"
					+ "--+-----------------------------+-----------------+-------------+");
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

	public static void deleteEmployee(Connection conn, Scanner sc) {
		try {
			System.out.println("-----------------DELETE EMPLOYEE---------------");
			System.out.print("ID: ");
			long id = Long.parseLong(sc.nextLine());
			if (checkDelete(id)) {
				String sqlDelete = "DELETE FROM Employee WHERE ID=?";
				pstmt = conn.prepareStatement(sqlDelete);
				pstmt.setLong(1, id);
				int count = pstmt.executeUpdate();
				System.err.println(count + "Change");

			} else {
				System.out.println("Employee No Existence!!!");
				System.out.println("Delete Failed!!!");
			}

		} catch (SQLException e) {
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}

	}

	public static void searchEmployee(Connection conn,Scanner sc) {
		while (true) {

			try {
				System.out.println("-----------------SEARCH EMPLOYEE---------------");
				System.out.println("Name: ");
				String name = sc.nextLine();
				String sqlSearch = "select * FROM Employee WHERE name=?";
				pstmt = conn.prepareStatement(sqlSearch);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				boolean isCheck = false;
				System.out.println("-----+-------------------------+---"
						+ "--+-----------------------------+-----------------+-------------+");
				System.out.printf("%-4S | %-23s | %-3s | %-27s | %-15s | %-7s | \n", "ID", "NAME", "AGE", "ADDRESS",
						"SALARY", "SUMTIMEWORK");
				System.out.println("-----+-------------------------+---"
						+ "--+-----------------------------+-----------------+-------------+");
				while (rs.next()) {
					isCheck = true;
					System.out.printf("%-4d | %-23s | %-3d | %-27s | %-15.2f | %-11d | \n", rs.getLong("ID"),
							rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getDouble("Salary"),
							rs.getInt("SumTimeWork"));

				}
				System.out.println("-----+-------------------------+---"
						+ "--+-----------------------------+-----------------+-------------+");
				if (isCheck) {
					break;
				} else {
					System.out.println("Khong tim thay thong tin nhan vien.");
					System.out.println("Ban co muon tiep tuc tim kiem khong? Y/N");
					String input = sc.nextLine();
					if ("n".equalsIgnoreCase(input)) {
						break;
					}
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

	}

	
	public static void search(ArrayList<Employee> list,Scanner sc) {
		System.out.println("--------------Searching Employee---------------");
		System.out.println("Name:");
		String name = sc.nextLine();
		int count = 0;
		System.out.println("-----+-------------------------+---"
				+ "--+-----------------------------+-----------------+-------------+");
		System.out.printf("%-4S | %-23s | %-3s | %-27s | %-15s | %-7s | \n", "ID", "NAME", "AGE", "ADDRESS", "SALARY",
				"SUMTIMEWORK");
		System.out.println("-----+-------------------------+---"
				+ "--+-----------------------------+-----------------+-------------+");
		for (Employee em : list) {
			if (name.equalsIgnoreCase(em.getName())) {				
				System.out.printf("%-4d | %-23s | %-3d | %-27s | %-15.2f | %-11d | \n", em.getId(), em.getName(), em.getAge(), em.getAddress(), em.getSalary(),
						em.getSumTimeWork());
				count++;
			}
		}
		System.out.println("-----+-------------------------+---"
				+ "--+-----------------------------+-----------------+-------------+");
		if(count==0) {
			System.out.println("NHAN VIEN KHONG TON TAI!!!!");
		}
	}
	public static ArrayList<Employee> getDB(Connection conn) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "select * from Employee";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Employee em;

			while (rs.next()) {
				em = new Employee();
				em.setId(rs.getLong("id"));
				em.setName(rs.getString("name"));
				em.setAge(rs.getInt("age"));
				em.setAddress(rs.getString("address"));
				em.setSalary(rs.getDouble("salary"));
				em.setSumTimeWork(rs.getInt("sumtimework"));
				list.add(em);
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

	public static void printListDB(ArrayList<Employee> list) {
		
		System.out.println("-----+-------------------------+---"
				+ "--+-----------------------------+-----------------+-------------+");
		System.out.printf("%-4S | %-23s | %-3s | %-27s | %-15s | %-7s | \n", "ID", "NAME", "AGE", "ADDRESS", "SALARY",
				"SUMTIMEWORK");
		System.out.println("-----+-------------------------+---"
				+ "--+-----------------------------+-----------------+-------------+");
		for (Employee em : list) {
			System.out.printf("%-4d | %-23s | %-3d | %-27s | %-15.2f | %-11d | \n", em.getId(), em.getName(), em.getAge(), em.getAddress(), em.getSalary(),
					em.getSumTimeWork());
		}
		System.out.println("-----+-------------------------+---"
				+ "--+-----------------------------+-----------------+-------------+");
	}

	public static int menu(Scanner sc) {
		int n;

		do {
			System.out.println("----------------CHUONG TRINH QUAN LY NHAN VIEN----------------");
			System.out.println();

			System.out.println();
			System.out.println("            1. Hiển Thị Thông Tin Toàn Bộ Nhân Viên");
			System.out.println("            2. Tìm Kiếm Nhân Viên Theo Tên");
			System.out.println("            3. Cập Nhật Thông Tin Nhân Viên");
			System.out.println("            4. Thêm Thông Tin Nhân Viên");
			System.out.println("            5. Xóa Thông Tin Nhân Viên");
			System.out.println("            6. Thoát");
			System.out.println();
			System.out.println("            Bạn Muốn Chọn Mục Nào?");
			System.out.print("....");
			n = Integer.parseInt(sc.nextLine());
	

		} while (!(n >= 1 && n <= 6));
		return n;
	}

	public static int menuUpdate(Scanner sc) {
		int n;

		do {
			System.out.println("----------------Update Employee----------------");
			System.out.println();

			System.out.println();
			System.out.println("            1. Update Name");
			System.out.println("            2. Update Age");
			System.out.println("            3. Update Address");
			System.out.println("            4. Update Salary");
			System.out.println("            5. Update SumTimeWork");
			System.out.println("            6. Update All");
			System.out.println();
			System.out.println("            Bạn Muốn Chọn Mục Nào?");
			System.out.print("....");
			n = Integer.parseInt(sc.nextLine());
		} while (!(n >= 1 && n <= 6));
		return n;
	}

	

	public static int manageProgram(int n,Scanner sc) {

		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database ...");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			switch (n) {
			case 1:
//				selectAllEmployee(conn,sc);
				ArrayList<Employee> list= getDB(conn);
				printListDB(list);
				break;
			case 2:
				ArrayList<Employee> listSearch= getDB(conn);
				search(listSearch,sc);
//				searchEmployee(conn,sc);
				break;
			case 3:
				updateEmployee(conn,sc);
				break;
			case 4:
				insertEmployee(conn,sc);
				break;
			case 5:
				deleteEmployee(conn,sc);
				break;
			case 6:
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
		return n;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			n = menu(sc);
			manageProgram(n,sc);

		} while (!"6".equalsIgnoreCase(String.valueOf(n)));

		sc.close();
	}

}

