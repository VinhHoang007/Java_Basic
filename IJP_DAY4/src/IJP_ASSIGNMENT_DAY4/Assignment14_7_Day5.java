package IJP_ASSIGNMENT_DAY4;
//Tính tổng và tích các chữ số của một số m, m được nhập từ bàn phím
import java.util.Scanner;

public class Assignment14_7_Day5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = 0;
		int P = 1;
		System.out.println("Input m: ");
		int m = sc.nextInt();
		while (m != 0) {
			int soDu = m % 10;
			m = m / 10;
			S += soDu;
			P *= soDu;

		}
		System.out.println("S: " + S);
		System.out.println("P: " + P);
		sc.close();
	}

}
