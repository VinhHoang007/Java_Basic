package fa.training.operators;

public class AssignmentOperators {

	public static void assignmentOperatorExample() {
		int a = 20, b = 10, c, d, e = 10, f = 4, g = 9;
		// simple assignment operator
		c = b;
		System.out.println("Value of c = " + c);

		a = a + 1;
		b = b - 1;
		e = e * 2;
		f = f / 2;
		System.out.println("a, b, e, f = " + a + ", " + b + ", " + e + ", " + f);
		a = a - 1;
		b = b + 1;
		e = e / 2;
		f = f * 2;

		// shorthand assignment operator
		a += 1;
		b -= 1;
		e *= 2;
		f /= 2;
		System.out.println("a, b, e, f (" + "using shorthand operators)= " + a + ", " + b + ", " + e + ", " + f);
	}

	public static void main(String[] args) {
		assignmentOperatorExample();
	}

}
