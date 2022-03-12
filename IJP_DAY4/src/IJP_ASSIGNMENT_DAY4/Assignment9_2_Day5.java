package IJP_ASSIGNMENT_DAY4;
//			  a  b
//In daŞy sôì 1, 2, 3, 5, 8, 13, …n (n laÌ sôì nhâòp vaÌo tıÌ baÌn phiìm) (*)
// Tong 2 so dau bang so sau a= b truoc b = sum vua tinh
import java.util.Scanner;

public class Assignment9_2_Day5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = sc.nextInt();

		int a = 0;
		int b = 1;
		int sum = 1;

		while (sum <= n) {
			System.out.print(sum + " ");
			a = b;
			b = sum;
			sum = a + b;
		}
		sc.close();
	}

}
