package ASSIGNMENT_DAY6_7;
//Viết hàm nhập và hàm hiển thị tất cả các giá trị đã nhập vào mảng số nguyên chứa N phần tử 
//(N nhập vào từ bàn phím)
import java.util.Scanner;

public class Assignment1_Day6_option1 {

	public static int[] input() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao n: ");

		int n = sc.nextInt();
		int[] arr = new int[n];

		System.out.println("Nhap cac phan tu mang: ");

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
//		sc.close();
		return arr;
	}

	public static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {

		int[] arr = input();
		displayArray(arr);
	}

}
