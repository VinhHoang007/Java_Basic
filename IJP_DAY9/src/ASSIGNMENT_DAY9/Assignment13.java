package ASSIGNMENT_DAY9;

import java.util.Scanner;

public class Assignment13 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Integer intNumber = null;
		         
		try {
		    System.out.println("Hãy nhập vào một số nguyên: ");
		    String strNumber = input.nextLine();
		    intNumber = new Integer(strNumber);
		} catch (NumberFormatException e) {
		    System.out.println("Vui lòng nhập vào một số nguyên");
		}
		         
		System.out.println("Chuyển thành Hexa: " + Integer.toHexString(intNumber));

	}

}
