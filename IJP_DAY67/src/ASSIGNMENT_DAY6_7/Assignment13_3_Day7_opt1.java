package ASSIGNMENT_DAY6_7;

import java.util.ArrayList;
import java.util.Scanner;

//Viết hàm lấy giá trị tại vị trí X (X nhập vào từ bàn phím) trong danh sách đã được tạo ở bài 2 
//và hiển thị giá trị tại vị trí X ra man hình (sử dụng hàm hiển thị ở câu 2)
public class Assignment13_3_Day7_opt1 {
	
	public static void getValue(ArrayList<Integer> list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao vi tri X:");
		int x = scanner.nextInt();
		
		Assignment12_2_Day7_opt1 getValue = new Assignment12_2_Day7_opt1();
		getValue.displayX(list, x); // dislay bai 12
		
	}
	public static void main(String[] args) {
		
		ArrayList<Integer> newList = new ArrayList<Integer>(); 
		Assignment12_2_Day7_opt1 list = new Assignment12_2_Day7_opt1();
		newList= list.inputArrayList();//goi ham nhap cac phan tu mang tu bai 12
		getValue(newList);
	}

}
