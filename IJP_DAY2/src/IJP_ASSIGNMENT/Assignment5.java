package IJP_ASSIGNMENT;

import java.util.Scanner;

public class Assignment5 {

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);

		System.out.println("Keyboar a: ");
		float a = key.nextFloat();
		System.out.println("Keyboar b: ");
		float b = key.nextFloat();

		System.out.println("output : " + (a = a + b));
		key.close();
	}

}
