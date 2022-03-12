package ASSIGNMENT_DAY10;

import java.util.Scanner;

//Viết hàm đếm xem có bao nhiêu phần tử có giá trị Nhỏ hơn X nhưng lớn hơn Y 
//trong mảng số nguyên A (đã được nhập vào từ bài 1 topic 1).
public class Assignment7_Day10_3_opt2 {
	
	public static void count(int x, int y,int [] arr) {
		int count=0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i] > y && arr[i] < x) {
				count++;
			}
		}
		System.out.println("So phan tu nam trong khoang"+"("+y+","+x+")" +": "+ count);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Assignment1_Day10_op1 input = new Assignment1_Day10_op1();
		int x,y;
		int [] arr = input.input(scanner);
		do {
			
			System.out.print("Nhap vao gia tri X:");
			x = scanner.nextInt();
			
			System.out.print("Nhap vao gia tri Y:");
			y = scanner.nextInt();
		} while (x<=y);
		count(x, y, arr);
	}

}
