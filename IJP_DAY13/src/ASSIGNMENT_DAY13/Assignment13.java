package ASSIGNMENT_DAY13;
//Tính S(n)=1^2+2^2+3^2+....+n^2 với n>0	
import java.util.Scanner;

public class Assignment13 {

	public static int square(int n) {
		if (n == 1) { // 1 mu may cung bang 1
			return 1;
		}
			return (int)(Math.pow(n, 2) + square(n - 1)); // gọi đệ quy
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so nguyen duong n:");
			n = scanner.nextInt();
		} while (n<=0);
		System.out.println(square(n)); 
		scanner.close();
	}
	
}
