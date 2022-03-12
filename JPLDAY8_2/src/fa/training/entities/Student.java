package fa.training.entities;

import java.util.Scanner;

public class Student {

	private String maSinhVien;
	private double diemTrungBinh;
	private int tuoi;
	private String lop;

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public Student(String maSinhVien, double diemTrungBinh, int tuoi, String lop) {
		super();
		this.maSinhVien = maSinhVien;
		this.diemTrungBinh = diemTrungBinh;
		this.tuoi = tuoi;
		this.lop = lop;
	}

	public Student() {
	}

	public void inputInfo(Scanner scanner) {
		do {
			System.out.println("=================INPUT=================");
			System.out.print("Ma So Sinh Vien : ");
			setMaSinhVien(scanner.nextLine());

			System.out.print("Tuoi: ");
			setTuoi(Integer.parseInt(scanner.nextLine()));

			System.out.print("Diem Trung Binh: ");
			setDiemTrungBinh(Double.parseDouble(scanner.nextLine()));
			

			System.out.print("Lop: ");
			setLop(scanner.nextLine());
			

		} while (!((this.maSinhVien.length() == 8) && (this.diemTrungBinh >= 0.0 && this.diemTrungBinh <= 10.0)
				&& (this.tuoi >= 18) && ((this.lop.charAt(0) == 'A') || (this.lop.charAt(0) == 'C'))));

	}

	public void showInfo() {
		
		System.out.println("Ma So Sinh Vien:\t" + getMaSinhVien());
		System.out.println("Tuoi           :\t" + getTuoi());
		System.out.println("Lop            :\t" + getLop());
		System.out.println("Diem Trung Binh:\t" + getDiemTrungBinh());
		if (checkScholarship()) {
			System.out.println("Du Dieu Kien Nhan Hoc Bong!!!");
		} else {
			System.out.println("Khong Du Dieu Kien!!!");
		}
		System.out.println("=====================================");

	}


	public boolean checkScholarship() {
		if (this.diemTrungBinh > 8.0) {
			return true;
		}
		return false;
	}

}
