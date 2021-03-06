package fa.training.operators;

import java.util.Scanner;

public class ArithmeticOperator {

	public static void arithmeticOperatorExample() {
		int a = 20, b = 10;
		String x = "Thank", y = "You";

		// + and - operator
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));

		// + operator if used with strings
		// concatenates the given strings.
		System.out.println("x + y = " + x + y);

		// * and / operator
		System.out.println("a * b = " + (a * b));
		System.out.println("a / b = " + (a / b));

		// modulo operator gives remainder
		// on dividing first operand with second
		System.out.println("a % b = " + (a % b));
	}

	public static void main(String[] args) {
		arithmeticOperatorExample();
	}

}
