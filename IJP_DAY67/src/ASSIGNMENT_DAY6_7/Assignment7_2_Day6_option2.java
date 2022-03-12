package ASSIGNMENT_DAY6_7;
//Viết hàm Thêm 01 phần tử có giá trị X vào vị trí Y trong mảng số nguyên bất kỳ 
//(Mảng số nguyên đã nhập trước đó);

import java.util.Scanner;

public class Assignment7_2_Day6_option2 {

	public static int[] insertElements(int[] arr, int x, int y) {
		int k = arr.length;

		int[] tempArray = new int[k + 1];
		int j = 0;
		for (int i = 0; i < tempArray.length; i++) {
			if (i == y) {
				tempArray[i] = x;
			} else {
				tempArray[i] = arr[j];
				j++;
			}
		}
		return tempArray;

	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {

		Assignment1_Day6_option1 input = new Assignment1_Day6_option1();
		int[] arr = input.input();
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap vao X:");
			int x = sc.nextInt();
			System.out.println("Nhap vao vi tri Y:");
			int y = sc.nextInt();

			int[] insertArray = insertElements(arr, x, y);

			display(insertArray);
		} catch (Exception e) {
			System.out.println("Kiem tra lai vi tri muon chen");
		}


	}
}
