package IJP_ASSIGNMENT;

import java.util.Scanner;

//Viết một chương trình Java cho phép người dùng chọn câu trả lời đúng của một câu hỏi.
//Xem ví dụ bên dưới:
//Cách chính xác để khai báo một biến để lưu trữ một giá trị số nguyên trong Java là gì?
//a. int 1x = 10;
//b. int x = 10;
//c. float x = 10.0f;
//d. chuỗi x = "10";
//Nhập sự lựa chọn của bạn: c	

public class Assignment6 {

	public static void main(String[] args) {
		boolean flag;
		Scanner sc = new Scanner(System.in);
		do {
			flag=true;
			System.out.println("======================================================================================");
			System.out.println("Cach chinh xac de khai bao mot bien de luu tru mot gia tri so nguyen trong java la gi?");
			System.out.println("======================================================================================");
			System.out.println("                                                                                      ");
			System.out.println("Dap an:");
			System.out.println("                                                                                      ");
			System.out.println("A. int 1x = 10;");
			System.out.println("B. int x = 10;");
			System.out.println("C. float x = 10.0f");
			System.out.println("D. chuoi x = \"10\"");
			System.out.println("======================================================================================");
			System.out.println("Su lua chon cua ban: ");
			

			String ans = sc.next();

			if ("b".equalsIgnoreCase(ans)) {
				System.out.println("Ket qua dung");
			} else {
				System.out.println("Ket qua sai");
				flag = false;
			}
		} while (!flag);

		sc.close();
	}
}
