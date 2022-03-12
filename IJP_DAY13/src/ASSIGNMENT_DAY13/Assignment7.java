package ASSIGNMENT_DAY13;

import java.util.Scanner;

//Tìm chữ số có giá trị lớn nhất của số nguyên dương n
public class Assignment7 {
	public static int max(int n,int max) {
		int r;
		if(n==0) {
			return max;
		}else {
			r= n%10;
			if(r>=max) {
				max = r;
			}
			return max(n/10,max);
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Nhap so nguyen duong n: ");
			n= scanner.nextInt();
			System.out.println(max(n,0));
		} while (n<0);
		scanner.close();
	}

}