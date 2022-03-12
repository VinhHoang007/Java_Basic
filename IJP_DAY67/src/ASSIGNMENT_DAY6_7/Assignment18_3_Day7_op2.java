package ASSIGNMENT_DAY6_7;

import java.util.ArrayList;
import java.util.Scanner;

//Viết hàm kiếm tra xem bao nhiêu phần tử có giá trị X trong danh sách chứa các phần tử số nguyên 
//(X nhập vào từ bàn phím);
public class Assignment18_3_Day7_op2 {
	static Scanner scanner = new Scanner(System.in);
	public static ArrayList<Integer>  inputArrayList() {
		
		System.out.println("So phan tu muon nhap: ");
		int n = scanner.nextInt();
		ArrayList<Integer>  list = new ArrayList<Integer> ();
		System.out.println("Nhap gia tri phan tu: ");
		for (int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		return list;
	}

	public static void check(ArrayList<Integer> list) {

		System.out.println("Phan tu muon kiem tra: ");
		int x = scanner.nextInt();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == x) {
				count++;
			}
		}
		System.out.println("So phan tu co gia tri bang "+x+": " + count);
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = inputArrayList();
		check(list);

	}

}
