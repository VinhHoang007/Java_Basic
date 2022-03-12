package IJP_ASSIGNMENT_DAY4;
import java.util.Scanner;

//In daŞy sôì 2, 4, -6, 8, 10, -12 … n (bãÌng iìt nhâìt 2 caìch khaìc nhau) (n laÌ sôì nhâòp vaÌo tıÌ baÌn phiìm)
public class Assignment6_2_Day4 {

	public static void main(String[] args) {
		System.out.print("Input n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for(int i = 2; i<=n; i+=2) {
			count++;
			if(count  == 3) {
			System.out.print(-i + " ");
			count = 0;
			}else {
			System.out.print(i + " ");
			}
		}
		sc.close();
	}
}