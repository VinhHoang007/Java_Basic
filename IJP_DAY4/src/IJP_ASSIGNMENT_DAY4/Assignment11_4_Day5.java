package IJP_ASSIGNMENT_DAY4;

//In da�y s�� 1, -3, 7, -15, 31, � (n la� s�� nh��p va�o t�� ba�n phi�m)
// vi tri chan la am
import java.util.Scanner;

public class Assignment11_4_Day5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input n: ");
		int n = scanner.nextInt();
		int count = 1;
		int sum = 1;
		while (sum <= n) {
			if (count % 2 == 0) {
				System.out.print(-sum + " ");
			} else {
				System.out.print(sum + " ");
			}
			sum = 2 * sum + 1;
			count++;
		}
		scanner.close();
	}

}
