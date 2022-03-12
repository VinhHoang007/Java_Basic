package ASSIGNMENT_DAY6_7;

import java.util.Random;
import java.util.Scanner;

//Viết hàm sinh ra N giá trị số nguyên bất kỳ cho mảng 
//và hiển thị các giá trị trong mảng ra màn hình (N nhập vào từ bàn phím)
public class Assignment2_Day6_option1 {
	
	public static int [] generatorArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so phan tu mang: ");
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		Random ran = new Random();
		
		for(int i = 0; i< n; i++) {
			arr[i] = ran.nextInt(100);
		}
		return arr;
	}
	
	public static void displayArray(int [] arr) {
		for(int i = 0; i <arr.length ; i++) {
			System.out.println("array["+i+"]: " + arr[i]);
		}
	}
	
	public static void main(String[] args) {
		
		int [] arr = generatorArray();
		displayArray(arr);

	}

}
