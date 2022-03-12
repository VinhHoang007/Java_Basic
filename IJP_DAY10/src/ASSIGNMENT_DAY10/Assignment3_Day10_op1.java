package ASSIGNMENT_DAY10;

import java.util.Scanner;
//Viết hàm hiển thị các vị trí chứa giá trị số nguyên X (X nhập vào từ bàn phím) trong mảng số nguyên A 
//(đã được nhập vào từ bài 1 topic 1). Nếu không có thì hiển thị -1.
public class Assignment3_Day10_op1 {

	public static void indexAppearance(int x, int []arr) {
		int count =0; 
		for(int i=0; i< arr.length;i++) {
			if(x == arr[i]) {
				System.out.print(i + " ");
				count++;
			}
		}
		if(count == 0) {
			System.out.println(-1);			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Assignment1_Day10_op1 input = new Assignment1_Day10_op1();
		int arr[] = input.input(sc);
			
		System.out.print("Nhap vao gia tri X:");
		int x = sc.nextInt();
		
		System.out.println("Vi tri xuat hien "+ x +" :" );
		indexAppearance(x,arr);
		sc.close();
		
	}

}
