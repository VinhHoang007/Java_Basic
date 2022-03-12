package ASSIGNMENT12;

import java.util.Scanner;
import java.util.Stack;

//Viết chương trình đổi 1 số nguyên dương từ hệ thập phân sang hệ bát phân.
public class Assignment4_Day12_op1 {


	public static long octal(int n) {
		Stack<Integer> st = new Stack<Integer>();
		int r;
		int count=0;
		long sum=0;
		while(n!=0) {
			r= n%8;
			n=n/8;
			st.push(r);
			count++;
		}
		while(count!=0) {
			count--;
			sum+=Math.pow(10, count)*st.pop();
		}
		return sum;
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so nguyen duong n:");
			n = scanner.nextInt();
		} while (n <= 0);
		System.out.println(octal(n));
		scanner.close();
	}

}


