package ASSIGNMENT_DAY13;

import java.util.Scanner;

//Tính dãy số Fibonacci sử dụng đệ quy
public class Assignment1 {

	public static long fibonaci(int n) {
		if (n == 1 || n == 2) { // Điều kiện thoát khỏi đệ quy
			return 1;
		} else {
			return fibonaci(n - 1) + fibonaci(n - 2); // gọi đệ quy
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int n= scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("So thu (" + i + ")= " + fibonaci(i));
		}
		scanner.close();
	}

}
