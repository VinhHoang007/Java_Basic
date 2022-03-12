package ASSIGNMENT12;
//Viết chương trình đổi 1 số nguyên dương từ hệ thập phân sang hệ nhị phân.
import java.util.Scanner;
import java.util.Stack;

public class Assignment5_1_Day12_opt2 {

	public static long binary(int n) {
		Stack<Integer> st = new Stack<Integer>();
		int r;
		int count=0;
		long sum=0;
		while(n!=0) {
			r= n%2;
			n=n/2;
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
		System.out.println(binary(n));
		scanner.close();
	}

}
