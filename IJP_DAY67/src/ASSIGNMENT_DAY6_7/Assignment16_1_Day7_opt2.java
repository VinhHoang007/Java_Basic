package ASSIGNMENT_DAY6_7;

import java.util.ArrayList;
import java.util.Scanner;

//Viết hàm tìm phần tử có giá trị X trong danh sách chứa các phần tử số nguyên (X nhập từ bàn phím). 
//Nếu có thì hiện thị ví trí của X trong Danh sách, Nếu không có thì hiển thị “Không có X” trong Danh sách.
public class Assignment16_1_Day7_opt2 {
	static Scanner scanner = new Scanner(System.in);

	public static ArrayList<Integer> inputArrayList() {

		System.out.println("So phan tu cua mang: ");
		int n = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Nhap gia tri phan tu: ");
		for (int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		return list;
	}

	public static void findX() {
		ArrayList<Integer> list = inputArrayList();
	
		System.out.println("Doi tuong can kiem tra");
		int x = scanner.nextInt();

		if (list.contains(x)) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == x) {
					System.out.println("Vi tri cua " + x + " la: " + i);
				}
			}
		} else {
			System.out.println("Khong ton tai "+x+ " trong mang");
		}

	}

	public static void main(String[] args) {

		findX();
	}

}
