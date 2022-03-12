package IJP_ASSIGNMENT_DAY4;
//S=1+1/2+1/3+....+1/n
import java.util.Scanner;

public class Assignment12_5_Day5 {
	public static void main(String[] args) {
		int n;
		do {
			System.out.print("Input n:");
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			sc.close();
		} while (n == 0);
		
		double s = 0;
		
		for(int i = 1; i <=n ; i++) {
			s += 1.0/i; 
		}
		System.out.println(s);
		
		
	}
}
