package ASSIGNMENT_DAY6_7;

import java.util.ArrayList;
import java.util.Scanner;

//Viết hàm hiển thị các phần tử số nguyên ở danh sách L2 không có trong danh sách L1 
//(Danh sách L2 ít hơn danh sách L1).
public class Assignment19_4_Day7_opt2 {
	public static ArrayList<Integer> inputArrayList() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("So phan tu muon nhap: ");
		int n = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Nhap gia tri phan tu: ");
		for (int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		return list;
	}
	public static void checkPrint(ArrayList<Integer> L1, ArrayList<Integer> L2) {
		L2.removeAll(L1);
		System.out.println(L2);
	}

	public static void main(String[] args) {
		ArrayList<Integer> L1 = inputArrayList();
		ArrayList<Integer> L2 = inputArrayList();
		checkPrint(L1, L2);
		
	}

}
