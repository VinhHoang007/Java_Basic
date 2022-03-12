package fa.training.main;

import java.util.ArrayList;
import java.util.Scanner;

import fa.training.entities.Student;

public class MyManagerStudent {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String choice = "";
		do {
			Student Sinhvien = new Student();
			Sinhvien.inputInfo(sc);
			studentList.add(Sinhvien);
			System.out.print("Ban co muon nhap tiep khong ? (Y/N): ");
			choice = sc.nextLine();
			
		} while ("Y".equalsIgnoreCase(choice));
		
		System.out.println("----------Information Student---------");
		for (Student sinhvien : studentList) {
			sinhvien.showInfo();
		}
		sc.close();
	}

}
//Nhap sai vs dk trong while student thi se nhap lai va k tinh kqua do. Con neu sai format thi ra loi