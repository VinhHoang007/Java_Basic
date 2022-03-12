package ASSIGNMENT_DAY6_7;

import java.util.Scanner;

/*
a)Nhập số lượng (N) Học viên, khai báo mảng chứa tên học viên, mảng chứa điểm Topic: SQL Basic,  
mảng chưa điểm Java Basic và mảng chứa Java Advanced cho từng học viên
b)Viết hàm Nhập tên học viên, nhập điểm các topic của từng học viên: SQL Basic, Java Basic, Java Advanced 
vào các mảng tương ứng
c)Hiển thị các giá trị đã nhập vào các mảng ở b)
d)Tính và hiển thị điểm trung bình của các học viên
e)Viết hàm hiển thị các học viên có điểm trung bình chung các Topic >= 6.5	
*/
public class Assignment10_5_Day6_option2 {

	public static double[] inputScoreArr(int n) {

		Scanner sc = new Scanner(System.in);
		double[] Score = new double[n];
		for (int i = 0; i < n; i++) {
			Score[i] = sc.nextDouble();
		}
		return Score;

	}

	public static String[] inputStudent(int n) {
		Scanner sc = new Scanner(System.in);
		String[] nameStudents = new String[n];
		System.out.println("Nhap vao ten sinh vien: ");
		for (int i = 0; i < n; i++) {
			nameStudents[i] = sc.nextLine();
		}
		return nameStudents;
	}

	public static void display(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void display(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void avg(String[] students, double[] sql, double[] javaBasic, double[] javaAdvance, int n) {
		double avg = 0.0;
		for (int i = 0; i < n; i++) {
			avg = (sql[i] + javaBasic[i] + javaAdvance[i]) / 3;
			System.out.println("Ten sinh vien:" + students[i] + " " + "Diem trung binh: " + avg);
		}
	}

	public static double avgTest(double sql, double javaBasic, double javaAdvance, int n) {
		double avg = 0.0;
		return avg = (sql + javaBasic + javaAdvance) / 3;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao so luong hoc vien: ");
		int n = sc.nextInt();
//============================================================		
		String[] students = inputStudent(n);
		System.out.println("Nhap vao diem SQL: ");
		double[] sqlScore = inputScoreArr(n);
		System.out.println("Nhap vao diem Java Basic: ");
		double[] javaBasicScore = inputScoreArr(n);
		System.out.println("Nhap vao diem Java Advance: ");
		double[] javaAdvanceScore = inputScoreArr(n);
//===========================================================		
		System.out.println("Danh sach sinh vien");
		display(students);
		System.out.println("Danh sach diem SQL");
		display(sqlScore);
		System.out.println("Danh sach diem Java Basic");
		display(javaBasicScore);
		System.out.println("Danh sach diem Java Advance");
		display(javaAdvanceScore);
//============================CAU D============================
		System.out.println("===============================CAU D=================================");
		double avgScore = 0;
		for (int i = 0; i < n; i++) {
			avgScore = avgTest(sqlScore[i], javaBasicScore[i], javaAdvanceScore[i], n);
			System.out.println("Ten sinh vien :" + students[i] + " || " + "Diem trung binh: " + avgScore);
		}
//============================CAU E============================
		System.out.println("===============================CAU E=================================");
		for (int i = 0; i < n; i++) {
			avgScore = avgTest(sqlScore[i], javaBasicScore[i], javaAdvanceScore[i], n);
			if (avgScore >= 6.5) {
				System.out.println("Ten sinh vien :" + students[i] + " || " + "Diem trung binh: " + avgScore);
			}
		}
	}
}
