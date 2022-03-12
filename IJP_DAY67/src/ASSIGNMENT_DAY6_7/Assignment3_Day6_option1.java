package ASSIGNMENT_DAY6_7;

import java.util.Scanner;

//Viết hàm hiển thị các giá trị chẵn trong mảng số nguyên chứa N phần tử (N nhập vào từ bàn phím). 
//Các giá trị của mảng được nhập từ hàm đã viết ở Bài 1.
public class Assignment3_Day6_option1 {

	public static void outputEvenElements(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	public static void main(String[] args) {

		Assignment1_Day6_option1 input = new Assignment1_Day6_option1();

		int[] arr = input.input();
		outputEvenElements(arr);
	}

}
