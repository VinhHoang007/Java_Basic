package IJP_ASSIGNMENT;

import java.util.Scanner;

//GIAI PHUONG TRINH BAC 1
public class Assignment6_3_option1 {

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);

		System.out.println("Input a: ");
		double a = key.nextDouble();

		System.out.println("Input b: ");
		double b = key.nextDouble();

		if (a == 0) {
			if (b == 0) {
				System.out.println("Phuong trinh vo so nghiem");
			} else {
				System.out.println("Phuong trinh vo nghiem");
			}
		} else {
			System.out.println("Phuong trinh co nghiem: " + (b / a));
		}
		key.close();

	}

}
