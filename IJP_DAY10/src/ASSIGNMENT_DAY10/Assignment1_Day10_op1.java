package ASSIGNMENT_DAY10;

import java.util.Scanner;

//Viết hàm tìm giá trị X (X nhập vào từ bàn phím) trong mảng số nguyên A 
//(đã được nhập vào từ bài 1 topic 1) và cho biết giá trị X có tồn tại trong mảng A hay không.
public class Assignment1_Day10_op1 {

	public int[] input(Scanner sc) {

		
		System.out.println("Nhap vao n: ");

		int n = sc.nextInt();
		int[] arr = new int[n];

		System.out.println("Nhap cac phan tu mang: ");

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}
	public static boolean findX(int x,int []arr) {
		for(int i=0; i< arr.length; i++) {
			if(x == arr[i]) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Assignment1_Day10_op1 input = new Assignment1_Day10_op1();
		Scanner sc= new Scanner(System.in);
		int []arr = input.input(sc);
		
		System.out.print("Nhap vao gia tri X:");
		int x = sc.nextInt();
		if(findX(x,arr)) {
			System.out.println(x +" TON TAI trong A");
		}else {
			System.out.println(x + " KHONG TON TAI trong A");
		}
		sc.close();
		
	}

}
