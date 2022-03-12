package ASSIGNMENT_DAY9;

public class Assignment10 {
	public static void main(String[] args) {
		try {
			int value = 10 / 0;
			System.out.println(value);

		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
