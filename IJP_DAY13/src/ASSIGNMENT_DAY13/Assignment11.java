package ASSIGNMENT_DAY13;

import java.util.Scanner;

//Tính S(n) = 1+3+5+..+(2.n+1) với n > 0
public class Assignment11 {
	public static int sumOdd(int n) {
		if(n == 0) {
			return 1;
		}else {
			return 2*n+1+sumOdd(n-1);
		}
	}
	


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so nguyen duong n:");
			n = scanner.nextInt();
		} while (n<=0);
		System.out.println(sumOdd(n));
		scanner.close();
	}

}
