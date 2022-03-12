package ASSIGNMENT_DAY6_7;

import java.util.Scanner;

//Viết hàm Xóa 01 phần tử ở vị trí Y trong mảng số nguyên bất kỳ 
//(Mảng số nguyên đã nhập trước đó);
public class Assignment8_3_Day6_option2 {
	public static int[] deletetElements(int[] arr, int pos) {
		int[] newArray = new int[arr.length - 1];
		int j = 0;
		for (int i = 0; i < newArray.length; i++) {
			if (j == pos) {
				newArray[i] = arr[j + 1];
				j++;
			} else {
				newArray[i] = arr[j];
			}
			j++;
		}

		return newArray;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {

		Assignment1_Day6_option1 input = new Assignment1_Day6_option1();
		int[] arrOriginal = input.input();

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao vi tri muon xoa:");
		int position = sc.nextInt();
		if (position < 0 || position > arrOriginal.length) {

			System.out.println("Kiem tra lai vi tri muon xoa");
		} else {

			int[] deleteArray = deletetElements(arrOriginal, position);
			display(deleteArray);
		}

	}

}
