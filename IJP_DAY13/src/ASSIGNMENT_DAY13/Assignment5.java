package ASSIGNMENT_DAY13;


import java.util.Scanner;

//In đảo ngược số nguyên dương
public class Assignment5 {
	
	public static int count(int n) {
		int count =0;
		while(n!=0) {
			n /=10;
			count++;
		}
		return count;
	}
	
	public static int reverse(int n) {

		if (n == 0) {
			return n;
		} else {			
			 return (int) ((n%10)*Math.pow(10, count(n)-1)+reverse(n/10));
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao n");
		int n = scanner.nextInt();
		System.out.println(reverse(n));
		scanner.close();
	}

}
