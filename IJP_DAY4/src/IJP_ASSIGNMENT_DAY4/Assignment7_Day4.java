package IJP_ASSIGNMENT_DAY4;

import java.util.Scanner;

//In da�y s�� 2, 4, 6, 8, 10 � 2n (n la� s�� nh��p va�o t�� ba�n phi�m) (*)
public class Assignment7_Day4 {

	public static void main(String[] args) {
		System.out.print("Input n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<= n ; i++) {
			System.out.print(2*i + " ");
		}
		sc.close();
	}	

}
