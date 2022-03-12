package IJP_ASSIGNMENT;

import java.util.Scanner;

public class Assignment5 {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		
		System.out.println("Input number: ");
		try {
			int number = key.nextInt();
			switch (number) {
			case 0: 

				System.out.println("So duoc nhan: " + number);
				break;
			
			case 1: 
				System.out.println("So duoc nhan: " + number);
				break;
			
			case 2: 

				System.out.println("So duoc nhan: " + number);
				break;
			
			case 3: 

				System.out.println("So duoc nhan: " + number);
				break;
			
			case 4: 

				System.out.println("So duoc nhan: " + number);
				break;
			
			case 5: 

				System.out.println("So duoc nhan: " + number);
				break;
			case 6: 

				System.out.println("So duoc nhan: " + number);
				break;
			
			case 7: 
				System.out.println("So duoc nhan: " + number);
				break;
			
			case 8: 
				System.out.println("So duoc nhan: " + number);
				break;
			
			case 9: 
				System.out.println("So duoc nhan: " + number);
				break;
			
			default:
				System.out.println("Khong duoc phep");
				break;
			}
		} catch (Exception e) {
			System.out.println("Khong duoc phep");
		}
		key.close();
	}

}
