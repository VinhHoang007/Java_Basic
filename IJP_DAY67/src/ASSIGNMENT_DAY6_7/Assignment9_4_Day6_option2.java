package ASSIGNMENT_DAY6_7;

import java.util.Scanner;

//Viết hàm Thêm N giá trị (N < 5 và được nhập vào từ bàn phím) vào các vị trí được xác định trong mảng K 
//(Khai báo trước hoặc nhập vào các vị trí cần chèn) vào 
//mảng số nguyên A cho trước hoặc nhập vào (mảng A có kích thước M); 
//Gợi ý: Nên sử dụng hàm ở bài 7 để giải quyết bài toán;
public class Assignment9_4_Day6_option2 {
	public static int[] inputArr() {
		int n;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Nhap vao n: ");
			n = sc.nextInt();
		} while (n !=4);
		
		int[] arr = new int[n];
		System.out.println("Nhap cac phan tu can chen: ");

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		return arr;
	}
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
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		int [] N = inputArr();
//		int [] N = {91,92,93,94};
		int [] K = {2,3,5,7};
		int [] A = {1,2,3,4,5,6};
		for(int i = 0; i< K.length; i++) {			
			A = insertElements(A, N[i], K[i]);
		}
		display(A);
	}

}
