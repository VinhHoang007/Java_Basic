package day14_version2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ASSIGNMENT_DAY14.Employee;

public class Methods {
	public Employee inputEm(Scanner scanner) {

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
	//kiem tra su ton tai của phan tu truoc khi delete
	public boolean checkDelete(long id, Connection conn, PreparedStatement pstmt) {
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
	// xoa phan tu ton tai trong databse
	public void deleteEmployee(Connection conn, PreparedStatement pstmt, Scanner sc) {
		try {
			System.out.println("-----------------DELETE EMPLOYEE---------------");
			System.out.print("ID: ");
			long id = Long.parseLong(sc.nextLine());
			if (checkDelete(id,conn,pstmt)) {
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
	// Kiem tra phan tu ton tai truoc khi insert
	public boolean checkInsert(Connection conn, PreparedStatement pstmt,Employee emp) {
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
	// insert object vao database
	public void insertEmployee(Connection conn, PreparedStatement pstmt, Scanner sc) {

		String sqlInsert = "INSERT INTO Employee(Name,Age,Address,Salary,SumTimeWork) " + "VALUES(?,?,?,?,?)";
		try {
			Employee em = inputEm(sc);
			if(!checkInsert(conn,pstmt,em)) {
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
	public int menuUpdate(Scanner sc) {
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
	// method update
	public void updateEmployee(Connection conn, Scanner sc,PreparedStatement pstmt) {

		Employee emp = new Employee();
		// Nhap ID
		System.out.print("Input ID:");
		long id = Integer.parseInt(sc.nextLine());

		// Kiem tra su ton tai của phan tu trong databse dựa trên id

		emp = checkUpdate(id,pstmt,conn);
		// Neu ton tai phan tu trong database thi tien hanh update theo yc ng dung. Dua tren bang sw
		// Trong qua trinh nay tien hanh update cac thuoc tinh cua doi tuong
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

			// Sau khi set cac thuoc tinh cua doi tuong thi tien hanh update

			update(conn, pstmt, emp);
		} else {
			System.out.println("Update Failed");
		}

	}

	public Employee checkUpdate(long id, PreparedStatement pstmt, Connection conn) {
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
	public void update(Connection conn, PreparedStatement pstmt, Employee emp) {
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
	
	// select khong dung doi tuong
	public void selectAllEmployee(Connection conn,PreparedStatement pstmt) {
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
	
	//Khong dung doi tuong. Tim kiem nhan vien theo ten
	public void searchEmployee(Connection conn, PreparedStatement pstmt, Scanner sc) {
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

	//Dung doi tuong. Tim kiem 1 nhan vien theo ten
	public void search(ArrayList<Employee> list,Scanner sc, PreparedStatement pstmt) {
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
	
	//Lay toan bo du lieu employee dua vao arraylist
	public ArrayList<Employee> getDB(Connection conn, PreparedStatement pstmt) {
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
	// In danh sach toan bo nhan vien theo arraylist.
	public void printListDB(ArrayList<Employee> list) {
		
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

}
