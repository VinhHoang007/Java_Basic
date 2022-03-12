package ASSIGNMENT_DAY13;

import java.util.Scanner;

//Tìm chử số đầu tiên của số nguyên duong n

public class Assignment10 {
	
	public static int findFirstNumber(int n) {
		if(n<10) {
			return n;
		}else {
			return findFirstNumber(n/10);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so nguyen duong n:");
			n = scanner.nextInt();
		} while (n<=0);
		System.out.println(findFirstNumber(n));
		scanner.close();
	}

}
