package ASSIGNMENT_DAY6_7;

import java.util.Scanner;

//Viết hàm chứa các giá trị LẺ trong mảng số nguyên A chứa N phần tử (N nhập vào từ bàn phím) vào mảng số nguyên LẺ B. 
//Các giá trị của mảng A được nhập từ hàm đã viết ở Bài 1.

public class Assignment5_Day6_option1 {
	public static int countEvenNumber(int[] arrA) {
		int count = 0;
		for (int i = 0; i < arrA.length; i++) {
			if (arrA[i] % 2 != 0) {
				count++;
			}
		}
		return count;
	}

	public static int[] createNewOddArray(int[] arrA) {

		int[] arrB = new int[countEvenNumber(arrA)];
		int index = 0;
		for (int i = 0; i < arrA.length; i++) {
			if (arrA[i] % 2 != 0) {
				arrB[index] = arrA[i];
				index++;
			}
		}
		return arrB;

	}

	public static void display(int[] arrB) {
		for (int i = 0; i < arrB.length; i++) {
			System.out.print(arrB[i] + " ");
		}
	}

	public static void main(String[] args) {

		Assignment1_Day6_option1 input = new Assignment1_Day6_option1();

		int[] arrA = input.input();

		int[] arrB = createNewOddArray(arrA);
		System.out.println("Phan tu trong mang B");
		display(arrB);
	}
}
