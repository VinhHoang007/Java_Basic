package IJP_ASSIGNMENT_DAY4;

import java.util.Scanner;

//In da�y s�� 1, 3, 5, 7, 9 � n (n la� s�� nh��p va�o t�� ba�n phi�m)
public class Assignment4_Day4 {
	
	public static void main(String[] args) {
		
		System.out.print("Nhap vao n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			if(i%2 !=0) {
				System.out.print(i + " ");				
			}
		}
//		System.out.print(n);
		sc.close();
	}
		
}
