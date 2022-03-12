package ASSIGNMENT_DAY13;

import java.util.Scanner;

public class Assignment8 {
	public static int logarit(int n) {
		if(n<0) {
			return -1;
		}else {
			if(n>=2) {
				return 1+ logarit(n/2);
			}else {
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so nguyen duong n:");
			n = scanner.nextInt();
		} while (logarit(n)==-1);

		System.out.println(logarit(n));
		scanner.close();
	}

}
