package IJP_ASSIGNMENT;

import java.util.Scanner;

//Gia�i ph��ng tri�nh b��c 2	
public class Assignment7 {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		
		System.out.println("Input a: ");
		double a = key.nextDouble();
		
		System.out.println("Input b: ");
		double b = key.nextDouble();
		
		System.out.println("Input c: ");
		double c = key.nextDouble();
		
		if(a==0) {
			
			if (b == 0) {
				if (c == 0) {
					System.out.println("Phuong trinh vo so nghiem");
				} else {
					System.out.println("Phuong trinh vo nghiem");
				}
			} else {
				System.out.println("Phuong trinh co 1 nghiem duy nhat: " + (c / b));
			}
		} else {
			
			double Delta = Math.pow(b, 2) - 4*a*c;
			if(Delta < 0) {
				
				System.out.println("Phuong Trinh Vo Nghiem");
				
			}else if (Delta == 0) {
				
				System.out.println("Phuong trinh co 1 nghiem kep: " + -b/(2*a));
			}else {
				
				double x1 = (-b-Math.sqrt(Delta))/2*a;
				double x2 = (-b+Math.sqrt(Delta))/2*a;
				System.out.println("Phuong trinh co 2 nghiem phan biet: " + x1 + " " + x2);
			}
		}
		key.close();
		
	}

}
