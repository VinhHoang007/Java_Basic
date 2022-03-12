package IJP_ASSIGNMENT;

import java.util.Scanner;

//Viết chương trình Java để xác định xem một số đầu vào có phải là số chẵn hay không
public class Assignment2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input x:");
		double x = sc.nextInt();
		
		if(x % 2== 0) {
			System.out.println("x la so chan");
		}else {
			System.out.println("x la so le");
		}
		sc.close();
	}

}
