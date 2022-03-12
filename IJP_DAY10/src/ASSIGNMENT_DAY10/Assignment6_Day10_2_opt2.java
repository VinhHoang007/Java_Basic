package ASSIGNMENT_DAY10;

import java.util.Scanner;

/*
Viết hàm đếm xem có bao nhiêu phần tử còn thiếu trong mảng số nguyên A chưa được sắp xếp (đã được nhập vào từ bài 1 topic 1). Nếu không có thì trả về 0. Chú ý: Các giá trị còn thiếu trong mảng nằm trong khoảng giá trị nhỏ nhất và lớn nhất trong mảng A;
Ví dụ 1:
Input: A[] = {2, 4, 10, 7}
Output: 3, 5, 6, 8, 9
Ví dụ 2: 
Input: A[] = {2, 10, 9, 4}
Output: 3, 5, 6, 7, 8
*/
public class Assignment6_Day10_2_opt2 {
	public static int getMax(int [] arr) {
		int max=arr[0];
		for(int i=1; i< arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	public static int getMin(int [] arr) {
		int min=arr[0];
		for(int i=1; i< arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}


	public static void getMissNumber(int x,int y,int []arr) {
		int count= 0;
		System.out.println("Phan tu bi thieu: ");
		for (int i = x+1; i < y;i++) {
			if(!check(arr, i)) {
				System.out.print(i+ " ");
				count++;
			}
		}
		if(count == 0) {
			System.out.print(0);
		}
		
	}
	
	public static boolean check(int [] arr,int k) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==k) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Assignment1_Day10_op1 input = new Assignment1_Day10_op1();
		int[] arr = input.input(sc);
		int y = getMax(arr);
		int x = getMin(arr);
		getMissNumber(x,y,arr);


	}

}
/*
public static int[] sort(int[] arr) {
	int tmp;
	for (int i = 0; i < arr.length; i++) {
		for (int j = i + 1; j < arr.length; j++) {
			if (arr[i] > arr[j]) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	}
	return arr;
}
*/
