package ASSIGNMENT_DAY10;

import java.util.ArrayList;
import java.util.Scanner;

//Hiển thị các giá trị trùng nhau trong mảng số nguyên A (đã được nhập vào từ bài 1 topic 1). 
//Nếu không có thì hiển thị 0;
public class Assignment5_Day10_1_opt2 {

	public static void duplicate(int[] arr) {
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j] && !tempArray.contains(arr[i])) {
					tempArray.add(arr[i]);
				}
			}
		}
		System.out.println("Mang ban dau: ");
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("Nhung phan tu trung lap trong mang");
		System.out.print(tempArray);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Assignment1_Day10_op1 input = new Assignment1_Day10_op1();
		int[] arr = input.input(sc);
		duplicate(arr);

	}

}
