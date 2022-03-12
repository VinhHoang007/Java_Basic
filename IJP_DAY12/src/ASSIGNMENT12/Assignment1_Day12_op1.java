package ASSIGNMENT12;

import java.util.Scanner;
import java.util.Stack;

//Cách in tổng n số trong Java?
public class Assignment1_Day12_op1 {
	public static void sum(int n) {
		int sum = 0;
		Stack<Integer> st = new Stack<>();
		
		for(int i=1;i<=n;i++) {
			st.add(i);
		}
		for(int i=0;i<n;i++) {
			sum+=st.pop();
		}
		System.out.print("sum: " + sum);
		
	}
	public static void main(String[] args) {
		System.out.println("Nhap vao n");
		Scanner scanner = new Scanner(System.in);
		sum(scanner.nextInt());
		scanner.close();
	}

}
