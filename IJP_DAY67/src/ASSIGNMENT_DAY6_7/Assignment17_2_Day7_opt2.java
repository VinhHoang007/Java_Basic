package ASSIGNMENT_DAY6_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Viết hàm kiểm tra xem hai danh sách số nguyên L1 và L2 có giống nhau hay không?
public class Assignment17_2_Day7_opt2 {
	
	public static ArrayList<Integer> inputArrayList() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("So phan tu muon nhap: ");
		int n = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Nhap gia tri phan tu: ");
		for(int i=0;i<n;i++) {
			list.add(scanner.nextInt());
		}
		return list;
		
	}

	public static boolean check(ArrayList<Integer> L1, ArrayList<Integer> L2) {
		Collections.sort(L1);
		Collections.sort(L2);
		System.out.println(L1);
		System.out.println(L2);
		if(L1.equals(L2)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		ArrayList<Integer> L1 = inputArrayList();
		ArrayList<Integer> L2 = inputArrayList();
				
		if(check(L1, L2)) {
			System.out.println("L1 giong L2");
		}else {
			System.out.println("L1 khac L2");
		}
	}

}
