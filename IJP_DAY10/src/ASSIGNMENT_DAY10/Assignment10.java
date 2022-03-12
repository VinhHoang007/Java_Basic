package ASSIGNMENT_DAY10;
//Cho một danh sách arr[] đã được sắp xếp gồm n phần từ , viết một hàm đưa ra vị trí của phần từ x trong mảng
//arr[] = {15, 20, 25, 30,31, 44,66 }. Tìm x = 25.

import java.util.Scanner;


//Tìm chử số đầu tiên của số nguyên duong n
public class Assignment10 {
	public static int findNumber(int []arr, int x) {
		int left= 0;
		int right = arr.length-1;
		int middle;
		while(left<=right) {
			middle = (left + right)/2;
			if(x> arr[middle]) {
				left = middle +1;
			}else if(x<arr[middle]) {
				right = middle -1;
			} else {
				return middle;
			}
		}
		return -1;
		
	}
	public static int [] input(Scanner scanner) {
		System.out.println("Nhap vao n:");
		int n = scanner.nextInt();
		int arr[] = new int[n];
		System.out.println("Nhap vao cac phan tu: ");
		for(int i=0; i< n;i++) {
			arr[i]= scanner.nextInt();
		}
		return arr;
	}
	public static int [] sortArray(int []arr) {
		int tmp;
		for(int i=0; i< arr.length;i++) {
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr [] = sortArray(input(scanner));
		System.out.println("Nhap vao gia tri X");
		int x = scanner.nextInt();
		int answer = findNumber(arr, x);
		if(answer != -1) {
			System.out.println(answer);
		}else {
			System.out.println("Gia tri can tim khong ton tai trong mang");
		}
		scanner.close();
		
	}

}

