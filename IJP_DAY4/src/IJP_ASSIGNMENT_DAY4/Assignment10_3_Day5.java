package IJP_ASSIGNMENT_DAY4;

import java.util.Scanner;

//In da�y s�� 1, 3, 7, 15, 31, �n (n la� s�� nh��p va�o t�� ba�n phi�m) quy luat 1+1+1 = 3, 3+3+1 =7
public class Assignment10_3_Day5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input n: ");
		int n = scanner.nextInt();
		int sum = 1;
		while(sum <= n) {
			System.out.print(sum+ " ");
			sum = 2*sum +1;
		}
		scanner.close();
	}

}
