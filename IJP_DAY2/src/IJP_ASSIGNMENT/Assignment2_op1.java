package IJP_ASSIGNMENT;

import java.util.Scanner;

//Viết chương trình Java bằng cách sử dụng lớp Scanner để nhập tên , 
//họ từ bàn phìm và sau đó  sẽ được hiển thị lên console
public class Assignment2_op1 {

	public static void main(String[] args) {
		
		Scanner sc = new  Scanner(System.in);

		
		System.out.println("Enter your fullname:");
		String fullname = sc.nextLine();
		System.out.println("Your fullname: " + fullname);
		sc.close();
	}
}
