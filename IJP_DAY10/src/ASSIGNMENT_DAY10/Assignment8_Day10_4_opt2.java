package ASSIGNMENT_DAY10;
/*
Viết Hàm in ra tất cả các cặp duy nhất trong mảng số nguyên A chưa được sắp xếp có tổng bằng nhau.
Ví dụ 1:
Input: A[] = { 4, 23, 65, 67, 24, 12, 86} 27 69 
Output: Cac cap: (4, 86) (23, 67) co tong bang: 90
Ví dụ 2: 
Input: A[] = { 6, 4, 12, 10, 22, 54, 32, 42, 21, 11}
Output:
Cac cap: ( 4, 12) ( 6, 10)  co tong bang: 16
Cac cap: ( 10, 22) ( 21, 11)  co tong bang: 32
Cac cap: ( 12, 21) ( 22, 11)  co tong bang: 33
Cac cap: ( 22, 21) ( 32, 11)  co tong bang: 43
Cac cap: ( 32, 21) ( 42, 11)  co tong bang: 53
Cac cap: ( 12, 42) ( 22, 32)  co tong bang: 54
Cac cap: ( 10, 54) ( 22, 42)  co tong bang: 64
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment8_Day10_4_opt2 {
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
	public static int [] sumArray(int [] arr) {
		int count = 0;
		int [] sumArr= new int[count(arr)];
		for(int i=0;i< arr.length-1;i++) {
			for(int j=i+1; j<arr.length;j++) {
				sumArr[count]= arr[i] + arr[j];
				count++;
			}
		}
		return sumArr;
	}
	public static int count(int [] arr) {
		int count =0;
		for(int i=arr.length-1; i>0;i--) {
			count+=i;
		}
		return count;
	}
	public static void display(int [] arr) {
		for(int i =0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static ArrayList<Integer> getSameSum(int []sumArr) {
		ArrayList <Integer> list = new ArrayList<Integer>(); 
		for(int i = 0; i< sumArr.length-1;i++) {
			for(int j=i+1;j< sumArr.length;j++) {
				if(!list.contains(sumArr[i])&&sumArr[i]==sumArr[j]) {
					list.add(sumArr[i]);
				}
			}
		}
		
		return list;	
	}
	public static void printNumber(ArrayList<Integer> listSum, int []arr) {
		for(int i=0; i< listSum.size();i++) {
			System.out.println("Sum: "+ listSum.get(i) );
			for(int m=0;m<arr.length-1;m++) {
				for(int n=m+1; n< arr.length;n++) {
					if(sum(arr[m],arr[n])==listSum.get(i)) {
						System.out.println("(" + arr[m]+ ", " + arr[n]+")");
						
					}
				}
			}
			System.out.println("--------------------");
		}
		
	}
	public static int sum(int a,int b) {
		return a+ b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = input(sc);
		int [] sumArr = sumArray(arr);
		System.out.println("============================================");
		ArrayList<Integer> listSum = getSameSum(sumArr);
//		display(sumArr);
		System.out.println("============================================");
		
//		for(int i=0;i<listSum.size();i++) {
//			System.out.println(listSum.get(i));
//		}
		printNumber(listSum, arr);
		sc.close();
	}

}
