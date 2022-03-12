package ASSIGNMENT_DAY10;
//Ví dụ: 

//Input: A[] ={0, 1, 2, 4, 6, 9, 11, 15}
//Output: 3
//Input: A[] ={1, 2, 4, 6, 9, 11, 15}
//Output: 0

import java.util.Scanner;

public class Assignment9 {
	public static int[] input(Scanner sc) {

		
		System.out.println("Nhap vao n: ");

		int n = sc.nextInt();
		int[] arr = new int[n];

		System.out.println("Nhap cac phan tu mang: ");

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}
	public static int[] sort(int[] arr) {
		int tmp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}

	public static boolean check(int [] arr,int left,int right,int x) {
		int mid;
		while(left<=right) {
			mid = (left+right)/2;
			if(arr[mid]==x) {
				return true;
			}else if(arr[mid] > x) {
				right = mid -1;
			}else {
				left = mid +1;
			}
		}
		return false;
	}




	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = input(sc);
		int[] sortArr = sort(arr);
		int min = sortArr[0];
		int max = sortArr[sortArr.length-1];
		
		int left = 0;
		int right = sortArr.length-1;
		
		if(min ==0) {
			for(int i=min; i<max;i++) {
				if(check(sortArr,left,right,i)==false) {
					System.out.println("Gia tri nho nhat con thieu" +i);
					break;
				}
			}
		}else {
			System.out.println("Gia tri nho nhat con thieu:" + 0);
		}
		sc.close();
	}

}


