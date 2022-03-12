package IJP_ASSIGNMENT;

import java.util.Scanner;

//Viết chương trình Java để cho phép người dùng nhập vào hai giá trị nguyên 
//và sau đó chương trình in ra kết quả cộng, trừ, nhân, chia giữa hai giá trị.
public class Assignment3 {

	public static void main(String[] args) {
		
		int a,b;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input a: ");		
		a = sc.nextInt();
				
		System.out.println("Input b: ");
		b = sc.nextInt();
		
		if(b == 0) {
			System.out.println("a + b = " + (a+b));
			System.out.println("a - b = " + (a-b));
			System.out.println("a * b = " + (a*b));
		}else {
			
			System.out.println("a + b = " + (a+b));
			System.out.println("a - b = " + (a-b));
			System.out.println("a * b = " + (a*b));
			System.out.println("a / b = " + (a/b));
		};
		sc.close();
	}

}
