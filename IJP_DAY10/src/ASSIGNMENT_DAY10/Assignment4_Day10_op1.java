package ASSIGNMENT_DAY10;

import java.util.Scanner;

//Viết hàm đếm xem có bao nhiêu phần tử có giá trị nằm trong khoảng [X,Y] (X và Y nhập vào từ bàn phím) 
//trong mảng số nguyên A (đã được nhập vào từ bài 1 topic 1). Nếu không có thì hiển thị -1.
public class Assignment4_Day10_op1 {

	public static void check(int x, int y, int []arr) {
		int count = 0;
		for(int i=0; i< arr.length; i++) {
			if(arr[i]> x && arr[i] <y) {
				count++;
			}
		}
		if(count !=0) {
			System.out.print("So phan tu thoa man: " + count);
		}else {
			System.out.print(-1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Assignment1_Day10_op1 input = new Assignment1_Day10_op1();
		int [] arr = input.input(sc);
		int x,y;
		do {
			
			System.out.print("Nhap vao gia tri X:");
			x = sc.nextInt();
			
			System.out.print("Nhap vao gia tri Y:");
			y = sc.nextInt();
		} while (y<x); // (x,y) => x < y

		check(x, y, arr);
		sc.close();
	}

}
