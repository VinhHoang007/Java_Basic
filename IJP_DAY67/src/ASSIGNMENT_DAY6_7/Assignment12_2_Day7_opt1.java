package ASSIGNMENT_DAY6_7;

import java.util.ArrayList;
import java.util.Scanner;
/*
Viết hàm nhập vào  N (Số lượng phần tử cần thêm vào Danh sách) và 
nhập lần lượt từng phần tử chứa giá trị số nguyên vào danh sách và 
viết hàm hiển thị tất cả các giá trị trong danh sách ra màn hình;
*/
public class Assignment12_2_Day7_opt1 {
	
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
	
	public static void display(ArrayList<Integer> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));;
		}
	}
	public static void displayTest(ArrayList<Integer> list) {
		System.out.println(list);
	}
	public static void displayX(ArrayList<Integer> list, int x) {		
				System.out.println("Phan tu vi tri" + "["+x+"]" +": " + list.get(x));;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = inputArrayList();
//		display(list);
		displayTest(list);
		
		
	}

}
