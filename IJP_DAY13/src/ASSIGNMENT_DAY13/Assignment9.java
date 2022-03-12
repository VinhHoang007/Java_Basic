package ASSIGNMENT_DAY13;

import java.util.Scanner;

public class Assignment9 {

	 public static long binary(int n){
	    long r;
	    if(n==0)
	         return 0;
	    else
	         r=n%2; 
	    return binary(n/2)*10 + r;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so nguyen duong n:");
			n = scanner.nextInt();
		} while (n<=0);
		System.out.println(binary(n));
		scanner.close();
	}

}
