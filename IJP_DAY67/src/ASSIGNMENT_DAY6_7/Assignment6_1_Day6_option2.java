package ASSIGNMENT_DAY6_7;

import java.util.Scanner;

//Viết hàm tính tổng các giá trị trong mảng số nguyên bất kỳ và 
//áp dụng tính tổng các giá trị số nguyên trong mảng Chẵn và Lẻ ở Bài 4 và 5;
public class Assignment6_1_Day6_option2 {

	public static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	public static void display(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			
			System.out.print(arr[i]);
		}
	}

	public static void main(String[] args) {
		Assignment1_Day6_option1 input = new Assignment1_Day6_option1();
		Assignment4_Day6_option1 even = new Assignment4_Day6_option1();
		Assignment5_Day6_option1 odd = new Assignment5_Day6_option1();
		
		int[] arr = input.input();
		
		int[] oddArray = odd.createNewOddArray(arr);

		int[] evenArray = even.createNewEvenArray(arr);

		System.out.println("Tong cac phan tu mang: " + sum(arr));
		sum(arr);
		System.out.println("Tong cac phan tu mang le: " + sum(oddArray));
		sum(oddArray);
		System.out.println("Tong cac phan tu mang chan: " + sum(evenArray));
		sum(evenArray);
	}

}
