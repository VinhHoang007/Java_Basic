package ASSIGNMENT_DAY13;

import java.util.Scanner;
/*
 USCLN(a,b) = b neu r =0;
 USCLN(a,b) = UCLN(b,r) neu r != 0
 a, b là hai số nguyên (giả sử a ≥ b), 
 thương q và số dư r (r ≥ 0) a = b*q + r
   
 */

/*
 BCNN = |a*b|/ UCLN(a,b)
 */
//Tìm USCLN và BSCNN của 2 số a và b sử dụng đệ quy
public class Assignment3 {
//	public static int USCLN(int a,int b) {
//		if(b==0) {
//			return a;
//		}else {
//			return USCLN(b,a%b);
//		}
//	}

	public static int USCLN(int a,int b) {
		if(a>=b) {			
			int c= a%b;
			if(c==0) {
				return b;
			}else {
				return USCLN(b,c);
			}
		}else {
			int c= b%a;
			if(c==0) {
				return a;
			}else {
				return USCLN(a,c);
			}
		}
	}

	public static int BSCNN(int a, int b) {
		if(a==b) {
			return a;
		}else {
			return a*b/USCLN(a,b);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a,b;
		do {
			System.out.println("Nhap a: ");
			a = scanner.nextInt();
			System.out.println("Nhap b: ");
			b = scanner.nextInt();
		} while (a==0|| b==0);
		

		System.out.println(USCLN(a,b));
		System.out.println(BSCNN(a,b));
		scanner.close();
	}

}
