package IJP_ASSIGNMENT;

import java.util.Scanner;

//Nhập vào 2 số nguyên, lưu vào 2 biến a và b. 
//Sau đó, đảo giá trị của 2 biến này rồi xuất giá trị của chúng ra màn hình console.	hiÌnh console.	
public class Assignment10_5_option1 {

	public static void main(String[] args) {

		int a, b;
		Scanner sc = new Scanner(System.in);

		System.out.println("Input a: ");
		a = sc.nextInt();

		System.out.println("Input b: ");
		b = sc.nextInt();

		int tmp;
		tmp = a;
		a = b;
		b = tmp;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		sc.close();
	}

}
