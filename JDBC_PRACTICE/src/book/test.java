package book;

import java.util.ArrayList;
import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		try {
			int value = 10 / 0;
			System.out.println(value);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}


	}

}
