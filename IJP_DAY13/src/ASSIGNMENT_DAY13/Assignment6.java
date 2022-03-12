package ASSIGNMENT_DAY13;

import java.util.Scanner;

//Đếm số lượng chữ số nguyên dương
public class Assignment6 {
	
	public static int countNumber(int n) {

		if(n<10) {
			return 1;
		}else {
			return 1+countNumber(n/10);
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap n");
			n = sc.nextInt();
			System.out.println(countNumber(n));
		} while (n<0);
		sc.close();	
	}

}
