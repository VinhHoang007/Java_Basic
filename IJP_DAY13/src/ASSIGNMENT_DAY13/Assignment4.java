package ASSIGNMENT_DAY13;

import java.util.Scanner;

//Tính tổng n số sử dụng đệ quy
public class Assignment4 {
	
	public static int sum(int n) {
		if(n==0) {
			return 0;
		}else {
			return n+sum(n-1);
		}
	}
	public static void main(String[] args) {
		System.out.println("Nhap vao n");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.print("Sum = "+sum(n));
		scanner.close();
	}

}
