package IJP_ASSIGNMENT_DAY4;

//In daŞy sôì 1, -3, 7, -15, 31, … (n laÌ sôì nhâòp vaÌo tıÌ baÌn phiìm)
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
