package ASSIGNMENT_DAY9;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("Hello");
		try {
			System.out.println(a.get(1));
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		



	}

}
