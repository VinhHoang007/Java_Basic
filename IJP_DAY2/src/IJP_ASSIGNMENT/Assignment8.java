package IJP_ASSIGNMENT;

import java.util.Scanner;

//Ti�nh chu vi va� di��n ti�ch hi�nh tro�n
public class Assignment8 {

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);
		
		System.out.println("Input r: ");
		double r = key.nextDouble();
		
		double chuVi = 2*Math.PI*r;
		double dienTich = Math.PI * Math.pow(r, 2);
		
		System.out.println("Dien tich hinh tron: " + dienTich);
		System.out.println("Chu vi hinh tron: " + chuVi);
		key.close();
	}

}
