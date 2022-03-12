package IJP_ASSIGNMENT_DAY4;

import java.util.Scanner;

//1, 2, 3, 4, 5 … n
public class Assignment3_Day4 {

	public static void main(String[] args) {
		
		System.out.print("Nhap vao n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.print(i + " ");
		}
		sc.close();
	}
}
