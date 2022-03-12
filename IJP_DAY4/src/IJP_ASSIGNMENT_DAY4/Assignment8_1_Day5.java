package IJP_ASSIGNMENT_DAY4;

import java.util.Scanner;

//In day so 2, -4, 6, 8, -10, 12, 14, 16, -18,.., n (**)
// Tinh chat day so am 1*4, 2*5, 3*6 ...
public class Assignment8_1_Day5 {

	public static boolean check(int x, int n) {
		int multi = 1;
		int i = 1;
		int j = 4;

		while (multi < n) {
			multi = i * j;

			if (x == multi) {
				return true;
			}
			i++;
			j++;

		}
		return false;
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Input n nguyen duong: ");
			int n = sc.nextInt();
			for (int i = 2; i <= n; i = i + 2) {
				if (check(i, n)) {
					System.out.print(-i + " ");
				} else {
					System.out.print(i + " ");
				}
			}
		}

	}

}
